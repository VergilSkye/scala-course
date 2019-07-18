package com.allaboutscala.chapter.three

import scala.util.control.TailCalls._

object FunctionTrampoline_Tutorial extends App {

  println("Step 1: How to define a trampoline function using scala.util.control.TailCalls")
  def verySweetDonut(donutList: List[String]): TailRec[Boolean] = {
    println(s"verySweetDonut function: donut list = $donutList")
    if(donutList.isEmpty) {
      println("verySweetDonut function: donut list isEmpty, returning false")
      done(false)
    } else {
      if(Set(donutList.head).subsetOf(Set("Vanilla Donut","Strawberry Donut","Glazed Donut"))) {
        println(s"verySweetDonut function: found donut list's head = ${donutList.head} to be VERY sweet, returning true")
        done(true)
      } else {
        println(s"verySweetDonut function: donut list's head = ${donutList.head} is NOT VERY sweet, forwarding donut list's to notSweetDonut function")
        tailcall(notSweetDonut(donutList))
      }
    }
  }

  println("\nStep 2: How to define a trampoline function using scala.util.control.TailCalls")
  def notSweetDonut(donutList: List[String]): TailRec[Boolean] = {
    println(s"notSweetDonut function: with donut list = $donutList")
    if(donutList.isEmpty){
      println("notSweetDonut function: donut list isEmpty, returning false")
      done(false)
    } else {
      println(s"notSweetDonut function: donut list's head = ${donutList.head} is NOT sweet, forwarding donut list's tail to verySweetDonut function")
      tailcall(verySweetDonut(donutList.tail))
    }

  }

  println("\nStep 3: How to call a trampoline tail recursive function")
  val donutList: List[String] = List("Plain Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")
  val foundVerySweetDonut = tailcall(verySweetDonut(donutList)).result
  println(s"Found very sweet donut = $foundVerySweetDonut")

}
