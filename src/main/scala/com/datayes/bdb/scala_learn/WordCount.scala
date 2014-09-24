package com.datayes.bdb.scala_learn

object WordCount extends Application{
	var list = List("warn msg 2003","warn msg 2341","error msg 2332")
	implicit def bool2int(b:Boolean)= if (b) 1 else 0
	val ll = list.map(_.split(" ")).map(_.toList).reduceLeft(_:::_)
	println(ll.map(_ == "msg").map(bool2int).reduceLeft(_ + _))
	
	println(list.map(_ split " ").map(_.count(_ == "msg")).reduceLeft(_+_))
	def countWord(arr:Array[String])=
	{
	  arr.count(_=="msg")
	}
	println(list.map(_ split " ").map(countWord).reduceLeft(_+_))
}