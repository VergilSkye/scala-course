package com.allaboutscala.chapter.three

object FunctionWithParameters_Tutorial extends App {

  println("Step 1: How to define function with parameters")
  def calculateDonutCost(donutName: String, quantity: Int): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")

    // make some calculations ...
    2.50 * quantity
  }



  println("\nStep 2: How to call a function with parameters")
  val totalCost = calculateDonutCost("Glazed Donut", 5)
  println(s"Total cost of donuts = $totalCost")



  println("\nStep 3: How to add default values to function parameters")
  def calculateDonutCost2(donutName: String, quantity: Int, couponCode: String = "NO CODE"): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity, couponCode = $couponCode")

    // make some calculations ...
    2.50 * quantity
  }

  println("\nStep 4: How to call a function with parameters that has default values")
  val totalCostWithDiscount = calculateDonutCost2("Glazed Donut", 4, "COUPON_12345")
  val totalCostWithoutDiscount = calculateDonutCost2("Glazed Donut", 4)

}
