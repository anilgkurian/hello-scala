package org.anil.scala.basic

import scala.util.{Failure, Success, Try}

/**
  * Created by anilgk on 4/28/17.
  */
object ScalaTry {

  def main(args: Array[String]): Unit = {

    checkResult(parseInt("2"))
    checkResult(parseInt("asd"))
  }

  private def checkResult(res: Try[Int]) = {
    res match {
      case Success(a) => println(a)
      case Failure(b) => println(b.getMessage)
    }
    println(res)
  }

  def parseInt(value: String): Try[Int] = Try(value.toInt)

}
