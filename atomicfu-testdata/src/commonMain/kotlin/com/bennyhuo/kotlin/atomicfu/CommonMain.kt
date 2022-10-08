package com.bennyhuo.kotlin.atomicfu

import kotlinx.atomicfu.AtomicInt
import kotlinx.atomicfu.atomic
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * Created by benny.
 */
// field with getter
//val counter = atomic(0)

// not a property accessor
// Unsupported return within atomic operation
// fun getCounter(any: Any): AtomicInt = counter // ERROR

class CommonMain {
  // CommonMain::counter field must be final
  // var counter = atomic(0)
}

// Unsupported return within atomic operation
// val CommonMain.counter1 // ERROR
//  get() = counter

// field cannot be public
// @JvmField
//val counter2 = atomic(0)
//
//fun counterGetterA() = counter
//fun counterGetterB(): AtomicInt {
//  println("get counter")
//  return counter
//}

fun commonMain() {
//  counter.value = 0
//  println(counter.value)
    val task = TaskAtomicFU()

}

//class Outer {
//  private val state = atomic(0)
//
//  companion object {
//    @JvmStatic
//    fun `access$getState$p`(`$this`: Outer) = `$this`.state
//  }
//
//  inner class Inner {
//    fun f() {
//      `access$getState$p`(this@Outer).compareAndSet(0, 1)
//    }
//  }
//}

