package com.allaboutscala.chapter.three


object FunctionHigherOrderAsParameters_Tutorial extends  App {



  println("Step 1: Review how to define function with curried parameter groups")
  def totalCost(donutType: String)(quantity: Int)(discount: Double): Double = {
    println(s"Calculating total cost for $quantity $donutType with ${discount * 100}% discount")
    val totalCost = 2.50 * discount
    totalCost - (totalCost * discount)
  }


  println("\nStep 2: How to define a higher order function which takes another function as parameter")
  def totalCostWithDiscountFunctionParameter(donutType: String)(quantity: Int )(f: Double => Double): Double = {
    println(s"Calculating total cost for $quantity $donutType")
    val totalCost = 2.50 * quantity
    f(totalCost)
  }


  println("\nStep 3: How to call higher order function and pass an anonymous function as parameter")
  val totalCostOf5Donuts = totalCostWithDiscountFunctionParameter("Glazed")(5){totalCost =>
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }
  println(s"Total cost of 5 Glazed with anonymous discount function = $totalCostOf5Donuts")



  println("\nStep 4: How to define and pass a function to a higher order function")
  def applyDiscount(totalCost: Double): Double = {
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }
  println(s"Total cost of 5 Glazed Donuts with discount function = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscount(_))}")


  /* using val instead of def */
  println("\nStep 5: How to define and pass a val function to a higher order function")
  val applyDiscountValueFunction = (totalCost: Double) => {
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }
  println(s"Total cost of 5 Glazed Donuts with discount val function = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscountValueFunction)}")

}
