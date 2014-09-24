package com.datayes.bdb.scala_learn
import java.io._
object Duck extends Application{
	def withClose(closeAble: {def close():Unit})(op:{def close():Unit} =>Unit)
	{
	  try{
	    op(closeAble)
	  }finally
	  {
	    closeAble.close()
	  }
	}
	class Connection{
	  def close() = println("close connection")
	}
	val conn : Connection = new Connection()
	withClose(conn)(conn=>println("do something with Connection"))
}