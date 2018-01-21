package scala


import java.text.SimpleDateFormat

import scala.annotation.tailrec
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer
import scala.io.Source


object Fibonacci extends App {


  def fibonacci(n:Int):Long = {
    val n1 = 1
    val n2 = 1

    @tailrec
    def f(n1: Long, n2: Long, remain: Int): Long = {
      remain match {
        case 0 => n1
        case _ =>
          f(n2, n1 + n2, remain - 1)
      }
    }

    f(1,1,n-1)
  }

  var count: Long = 0

  def fib2(n: Long): Long = {
    count += 1
    n match {
      case 1 | 2 => 1
      case _ =>
        fib2(n-1) + fib2(n-2)
    }
  }


  def time[T](t: =>T): T  = {
    val b = System.nanoTime()
    val x = t
    val e = System.nanoTime();
    println("time: " + (e-b)/1000 + "us");
    x
  }


}
