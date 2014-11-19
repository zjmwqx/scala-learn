package com.datayes.bdb.scala_learn

import scala.collection.mutable.ArrayBuffer

/**
 * Created by zhoujimin on 14-11-18.
 */
object TraitTest extends App{
  class CAnaimal
  trait TBeatable extends CAnaimal{
    def beat = println("beat")

  }
  class CDog extends TBeatable
  val dog = new CDog
  dog.beat

  class CPoint(val x: Int, val y: Int)

  trait TRactanglar {
    def topLeft: CPoint
    def bottomRight: CPoint
    def left = topLeft.x
    def right = bottomRight.x
    def width = left-right
  }
  //我们发现了下面这个情况：当去掉val时候，会出现问题，scala有时候确实很诡异。
  class CRactangle(val topLeft: CPoint, val bottomRight: CPoint) extends TRactanglar{
    def printWidth = println(width)
  }

  val ract = new CRactangle(new CPoint(1,2), new CPoint(3,5))
  ract.printWidth

  abstract class Que{
    def inQue(data: Char)
    def get
  }
  class CharQue extends Que{
    private val buf = new ArrayBuffer[Char]
    def inQue(data: Char) =
    {
      buf += data
    }
    def get() = buf.remove(0)
    def show = println(buf)
  }
  implicit def int2Char(v: Int) =
  {
    v.toChar
  }
  trait Doubling extends Que{
    abstract override def inQue(data: Char)
    {
      super.inQue(data+1)
    }
  }
  val que = new CharQue with Doubling
  que.inQue('c')
  que.show
}
