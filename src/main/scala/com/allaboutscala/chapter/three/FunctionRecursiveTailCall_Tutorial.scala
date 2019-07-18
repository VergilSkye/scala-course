package com.allaboutscala.chapter.three

object FunctionRecursiveTailCall_Tutorial {

  println("\nStep 1: Review how to define a tail recursive function")
  @annotation.tailrec
  def search(donutName: String, donuts: Array[String], index: Int): Option[Boolean] = {
    if(donuts.length == index) {
      None
    } else if(donuts(index) == donutName) {
      Some(true)
    } else {
      val nextIndex = index + 1
      search(donutName, donuts, nextIndex)
    }
  }


  println("\nStep 2: Review how to call a tail recursive function")
  val arrayDonuts: Array[String] = Array("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")
  val found = search("Glazed Donut", arrayDonuts, 0)
  println(s"Find Glazed Donut = $found")


  println("\nStep 3: How to define a tail recursive function using scala.util.control.TailCalls._")



}
