package org.anil.scala.basic

/**
  * Created by anilgk on 6/20/17.
  */
object HigherOrderFunctions {

  def log(msg: String, fn: String => Unit = Logger.logWarning){
    fn(msg)
  }

  def main(args: Array[String]): Unit = {
    log("some warning")
    log("some error", Logger.logError)
  }
}

object Logger {
  def logError(msg: String) {
    println("ERR : " + msg)
  }

  def logWarning(msg: String) {
    println("WARN: " + msg)
  }
}
