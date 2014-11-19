package com.datayes.bdb.scala_train

/**
 * Created by zhoujimin on 14-11-3.
 */
object Panlindrom extends App{
  val alg196 = (n : Int) => n + n.toString.reverse.toString
  val ll = for{
    x<-1 until 10
    y = alg196(x)
  }yield y
  //def isPanlindrom
  println(ll)

  def isPanlindrom[T <% Ordered[T]](a : List[T]):Boolean = a match
  {
    case Nil | _::Nil => true
    case a::xs => a == xs.last && isPanlindrom(xs.init)
  }
  println((1 until 100).filter(x=>isPanlindrom(x.toString.toList)))
}
