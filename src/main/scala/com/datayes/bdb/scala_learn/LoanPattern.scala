package com.datayes.bdb.scala_learn
import java.io._
import java.util._
/**
 * loan pattern : resource management
 *
 */

object LoanPattern extends App{
	def writeFileProxy(file:File, op:PrintWriter => Unit)
	{
	  val pw = new PrintWriter(file)
	  try{
	    op(pw)
	  }finally{
	    pw.close()
	  }
	}
	def readFileProxy(file:File, op:Scanner => Unit)
	{
	  val sc = new Scanner(file)
	  try{
	    op(sc)
	  }finally {
	    sc.close
	  }
	}
	val file = new File("README.md")
	writeFileProxy(file, pw => pw.println("hello zjm" + new java.util.Date()))
	readFileProxy(file, sc=>println(sc.nextLine()))

  trait TAction {
    def doAction
  }
  trait TRead extends TAction {
    def doAction= {
      val sc = new Scanner(file)
      try{
        println("do log")
        //super.doAction
      }finally {
        sc.close
      }
    }
  }

  class RealAction extends TRead{
    override def doAction = {
      println("do action")
    }
  }
  val readAction = new RealAction
  readAction.doAction
}

