package com.datayes.bdb.scala_learn
import scala.collection.mutable
import scala.collection.mutable.WeakHashMap
/**
 * Hello world!
 *
 */
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) {sum += b}
  def checksum(): Int = ~(sum & 0xFF) + 1
  def unary_-() { sum = -sum}
}
object ChecksumAccumulator extends App {
  private val cache = new WeakHashMap[String, Int]
  def calculate(s: String): Int = {
    if(cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for(c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s->cs)
      cs
    }
  }
  println(ChecksumAccumulator.calculate("Every value is an object."))
  var a = 1
  val b = 2
  a += 1
  println(1.0/0 isInfinity)

}
