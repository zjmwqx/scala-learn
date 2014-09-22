package com.datayes.bdb.scala_learn

object CallByName extends Application {
  val isWrong = false
  def func1(msg: String) = {
    if(isWrong) println(msg)
  }
  def func2(msg: => String)={
    if(isWrong) println(msg)
  }
  func2("hello"+ 1/0)
  val assertionsEnabled = true
  def boolAssert(pred: Boolean) =
  {
    if(assertionsEnabled && !pred)
      throw new AssertionError
  }
  boolAssert(3 / 0 < 2)
}
