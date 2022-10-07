package com.bennyhuo.kotlin.atomicfu

import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.getAndUpdate
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater

/**
 * Created by benny.
 */
class Task : Runnable {

  private val state = AtomicInteger(STATE_READY)

  fun start() {
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

class TaskFU : Runnable {

  companion object {
    private val fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(
      TaskFU::class.java,
      "state"
    )
  }

  @Volatile
  private var state = STATE_READY

  fun start() {
    val prev = fieldUpdater.getAndUpdate(this) { prev ->
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
    val prev = fieldUpdater.getAndUpdate(this) { prev ->
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