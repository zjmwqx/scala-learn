package com.datayes.bdb.scala_learn

object Generic extends Application{
	def withClose[A <:{def close():Unit},B](closeAble: A)(op: A =>B): B =
	{
	  try{
	    op(closeAble)
	  }finally{
	    closeAble.close
	  }
	}
}