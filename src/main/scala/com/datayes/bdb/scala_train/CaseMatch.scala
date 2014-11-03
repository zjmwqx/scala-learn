package com.datayes.bdb.scala_train

/**
 * Created by zhoujimin on 14-11-3.
 */
case class Power(val base: Symbol, val exp: Int)
{
  def ++ ()={
    Power(base, exp+1)
  }
}
object CaseMatch extends App{
  val ll = Power('a, 2) :: Power('b, 3) :: Power('c, 5) :: Nil
  val case0 = ll flatMap {
    case p@Power('a, x) => Some(p ++)
    case _ => None
  }
  println(case0)
}
