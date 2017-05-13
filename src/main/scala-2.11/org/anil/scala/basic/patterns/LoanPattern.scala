package org.anil.scala.basic.patterns

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

}
