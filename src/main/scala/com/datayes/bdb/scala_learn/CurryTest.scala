package com.datayes.bdb.scala_learn

/**
 * Created by zhoujimin on 14-11-19.
 */
object CurryTest extends App{
  def curriedSum(x: Int)(y: Int) = x + y
  val f1 = curriedSum(1) _
  println(f1(2))
  //继承代参数构造函数
  abstract class Elem(val data :Int){
    def elemSize : Int
  }
  //典型的安全的继承写法，抽象父类的object中写继承他得子类。并private，定义工厂方法
  object Elem{
    class ElemEx(val x :Int) extends Elem(x) {
      var elemSize = x
    }
    def ElemEx(x: Int) =
    {
      new ElemEx(x)
    }
  }
  import Elem.ElemEx
  val ex = ElemEx(10)
  println(ex.elemSize)
}
