package org.anil.scala.json

import org.json4s.jackson.Serialization

import scala.collection.immutable.Map

/**
  * Created by Anil on 4/25/18.
  */
case class Person(name: String, age: Int, location: String) extends DefaultJsonField

case class Company(name:String, location: String) extends DefaultJsonField

case class CustomFields(valueMap: Map[String, String])

case class Employee(person: Person, company: Company, customFields: CustomFields) extends DefaultJsonField

object JsonConverterTest{
  def main(args: Array[String]): Unit = {
    val person=Person("Anil",30,"Bangalore")
    val company = Company("ABCD","Delhi")
    val customFields = CustomFields(Map("Salaray"->"1000","Skills"->"Scala"))

    val employee = Employee(person,company,customFields)


    val json = Serialization.write(employee.toMap())
    import org.json4s.jackson.JsonMethods._
    println(pretty(render(parse(json))))
  }
}

sealed trait DefaultJsonField {

  def toMap(): Map[String, Any] = {
    covertToMap(this)
  }

  private def covertToMap(ref: AnyRef) =

    ref.getClass.getDeclaredFields.foldLeft(Map[String, Any]()){
      (map, field) => {
        field.setAccessible(true)
        val value = field.get(ref)
        value match {
          case c: CustomFields => {
            map ++ c.valueMap
          }
          case _ => {
            map + (field.getName -> value)
          }
        }
      }
    }

}
