package com.datayes.bdb.scala_learn

/**
 * Created by zhoujimin on 14-11-16.
 */
object PrintTable extends App{
  def makeRow(rowId : Int) = {
    val rowseq = for( col <- 1 to 10) yield{
      val prod = (rowId * col).toString
      val pedding = " " * (4 - prod.length)
      pedding + prod
    }
    rowseq.mkString
  }


  def multiTable() = {
    val tableSeq =
      for(row <- 1 to 10)
        yield{
        makeRow(row)
      }
    tableSeq.mkString("\n")
  }
  println(multiTable())

}
