package com.allaboutscala.chapter.random

object Tuples_Pattern extends App{
  val pastries = List(("Chocolate Cupcake", 2.50),
    ("Vanilla Cupcake", 2.25),
    ("Plain Muffin", 3.25),
    ("Bread", 2.0))

  pastries foreach { pastry =>
    pastry match {
      case ("Plain Muffin", price) => println(s"Buying muffin for $price")
      case p if p._1 contains "Cupcake" => println(s"Buying cupcake for ${p._2}")
      case _ => println("We don't sell that pastry")
    }
  }
}
