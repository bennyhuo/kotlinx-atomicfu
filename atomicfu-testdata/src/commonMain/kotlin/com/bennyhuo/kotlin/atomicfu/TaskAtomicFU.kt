package com.bennyhuo.kotlin.atomicfu

import kotlinx.atomicfu.AtomicInt
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.getAndUpdate

const val STATE_READY = 0
const val STATE_WORKING = 1
const val STATE_DONE = 2
const val STATE_CANCELLED = -1

class TaskAtomicFU : Runnable {

  private val state = atomic(STATE_READY)

  //
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
