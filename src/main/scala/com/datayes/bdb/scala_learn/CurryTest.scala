package com.datayes.bdb.scala_learn

/**
 * Created by zhoujimin on 14-11-19.
 */
object CurryTest extends App{
  def curriedSum(x: Int)(y: Int) = x + y
  val f1 = curriedSum(1) _
  println(f1(2))
}
