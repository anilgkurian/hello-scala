package org.anil.scala.basic

/**
  * Created by anilgk on 6/14/17.
  */
object OptionalParameter {

  def methodVersion1(firstName: String, lastName: String): Unit = {
    println(firstName + " " + lastName)
  }

  def methodVersion2(firstName: String, lastName: String="", middleName: String = ""): Unit = {
    if (middleName.isEmpty)
      println(firstName + " " + lastName)
    else
      println(firstName + " " + middleName + " " + lastName)
  }

  def methodVersion3(firstName: String, lastName: String="", middleName: String = ""): Unit = {
    if (middleName.isEmpty)
      println(firstName + " " + lastName)
    else
      println(firstName + " " + middleName + " " + lastName)
  }


  def main(args: Array[String]): Unit = {
    methodVersion3("Anil")
    methodVersion3("Anil", "Kurian")
    methodVersion3("Anil", "Kurian", "G")
    methodVersion3("Anil", middleName="G")
  }
}
