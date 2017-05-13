package org.anil.scala.patterns

import java.io.{File, PrintWriter}

/**
  * Created by anilgk on 5/13/17.
  */
class LoanPattern {

  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try
      op(writer)
    finally
      writer.close()
  }

  def withCurryingPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try
      op(writer)
    finally
      writer.close()
  }

  def main(args: Array[String]): Unit = {
    withPrintWriter(
      new File(""),
      writer => writer.println("hello")
    )

    // can use {} here as it takes only one param
    val file = new File("")

    withCurryingPrintWriter(file) {
      writer => writer.println("hello")
    }
  }
}
