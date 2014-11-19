package com.datayes.bdb.scala_train

/**
 * Created by zhoujimin on 14-11-4.
 */
object PascalTriangle {
  def pascalTriangle(n :Int) ={
    def nestWhileList[A](f: A => A, initial: A, p: A => Boolean) = {
      val result = Stream.iterate(initial)(f).takeWhile(p).toList
      result :+ f(result.last)
    }
  }
}
