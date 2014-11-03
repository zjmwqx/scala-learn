package com.datayes.bdb.scala_train

/**
 * Created by zhoujimin on 14-11-3.
 */
object Qsort extends App{
  def qsort1[T <% Ordered[T]](list:List[T]): List[T] = list match {
    case Nil => Nil
    case p::xs => val (lesser, greater) = xs.partition(_ <= p)
      qsort1(lesser) ++ List(p) ++ qsort1(greater)

  }

  def qsort2[T <% Ordered[T]](list:List[T]): List[T] = list match {
    case Nil => Nil
    case p::xs => qsort2(for(x <- xs if x <= p) yield x) ++
      List(p) ++ qsort2(for(x <- xs if x > p) yield x)
  }
  println(qsort1(List(1,2,3,5,4)))
}
