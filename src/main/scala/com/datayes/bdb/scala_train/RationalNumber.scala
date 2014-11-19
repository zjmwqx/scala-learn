package com.datayes.bdb.scala_train
import java.lang.Thread
/**
 * Created by zhoujimin on 14-11-10.
 */
class RationalNumber(n :Int, d: Int){
  require(d != 0)
  private val g = gcd(n, d)
  def this(n: Int) = this(n, 1)
  val domain = d/g
  val number = n/g
  override def toString = number + "/" + domain
  def +(that :RationalNumber) :RationalNumber =
    new RationalNumber(number * that.domain + that.number * domain, domain * that.domain)
  implicit def intToRational(x :Int) = {
    new RationalNumber(x)
  }
  def lessThen(that: RationalNumber) = {
    this.number * that.domain < that.number * this.domain
  }
  def max(that: RationalNumber) ={
    //如果上面不加=号。则返回空。
    if(this.lessThen(that)) that else this
  }
  def *(that: RationalNumber) = {
    new RationalNumber(number*that.number, domain * that.domain)
  }
  def gcd(a: Int, b: Int):Int = {
    if(b == 0) a else gcd(b, a % b)
  }
  def +(i:Int) ={
    new RationalNumber(number +i * domain,number)
  }

}

object RationalNumber extends App{
  val x = new RationalNumber(1,3)
  println(x)
  println(x + new RationalNumber(3,5))
  val m = new RationalNumber(2,7)
  val n = new RationalNumber(3,5)
  println(m.max(n))

  val v = new RationalNumber(42,108)
  println(v)
  Thread.`yield`()

}
