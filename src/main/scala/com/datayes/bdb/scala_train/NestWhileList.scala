package com.datayes.bdb.scala_train

/**
 * Created by zhoujimin on 14-11-4.
 */
object NestWhileList {
  def nestWhileList[A](f: A=>A, init:A, p: A=>Boolean) = {
    val result = Stream.iterate(init)(f).takeWhile(p).toList
  }
}
