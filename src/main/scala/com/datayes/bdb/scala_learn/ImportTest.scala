package com.datayes.bdb.scala_learn

/** * Created by zhoujimin on 14-11-21. */
object ImportTest extends App {

  abstract class Fruit(val kind: String)

  class Apple extends Fruit("Apple")

  object Fruit {
    def Fruit(kind: String): Fruit =
      kind match {
        case "Apple" => new Apple
      }
  }

  import Fruit._

  var apple = Fruit("Apple")
}
package p {

class Super {
  protected def f() {
    println("f")
  }
}

class Sub extends Super {
  f()
}


}
class Rocket {
  import Rocket.fire
  val test = fire
}
object Rocket {
  val fire : String = "hi"
}
