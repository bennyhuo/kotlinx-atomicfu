package com.bennyhuo.kotlin.atomicfu

import kotlinx.atomicfu.AtomicInt
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.getAndUpdate
import kotlin.js.JsExport

const val STATE_READY = 0
const val STATE_WORKING = 1
const val STATE_DONE = 2
const val STATE_CANCELLED = -1

val topLevelProperty = atomic(true)

val topLevelDelegateA by topLevelProperty

val topLevelDelegateB by atomic(true)

class TaskAtomicFU : Runnable {

  val array = arrayOf("kotlinx-atomicfu", "kotlinx-atomicfu2")

  val state = atomic(STATE_READY)

  val stateA by state
  val stateB by atomic(STATE_READY)

  // willBeRemoved
  fun willBeRemoved(state: AtomicInt) {

  }

  fun start() {
    // invocation of method com.bennyhuo.kotlin.atomicfu.TaskAtomicFU::willBeRemoved on atomic types.
    // Make the latter method 'inline' to use it
    // willBeRemoved(state) // ERROR

    val prev = state.getAndUpdate { prev ->
      when (prev) {
        STATE_READY -> STATE_WORKING
        else -> prev
      }
    }
    if (prev == STATE_READY) {
      // notify started.
    }
  }

  fun cancel() {
    val prev = state.getAndUpdate { prev ->
      when (prev) {
        STATE_READY, STATE_WORKING -> STATE_CANCELLED
        else -> prev
      }
    }

    if (prev == STATE_READY || prev == STATE_WORKING) {
      // notify cancelled.
    }
  }

  override fun run() {
    TODO("Not yet implemented")
  }
}
