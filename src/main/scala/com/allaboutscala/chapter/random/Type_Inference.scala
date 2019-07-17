package com.allaboutscala.chapter.random

object Type_Inference extends App {
  val businessName = "Montreux Jazz Café"
  def squareOf(x: Int) = x * x
  def fac(n: Int):Int = if (n == 0) 1 else n * fac(n - 1) // def fac(n: Int) = if (n == 0) 1 else n * fac(n - 1) without return type
  print(fac(4))

}
