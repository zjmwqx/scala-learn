package com.datayes.bdb.scala_train

/**
 * Created by zhoujimin on 14-11-3.
 */
object PowerSet extends App{
  def powerSet[T](s : Set[T]) = {
    s.foldLeft(Set(Set.empty[T])){
      (set, element) => set.union(set.map(_ + element))
    }
  }
  val ps = powerSet(Set(1,2,3))
  println(ps.toString)

}
