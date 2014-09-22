package com.datayes.bdb.scala_learn
import java.io._
import java.util._
/**
 * loan pattern : resource management
 *
 */

object LoanPattern extends Application {
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
	val file = new File("testDoc/loanPatern.md")
	writeFileProxy(file, pw => pw.println("hello zjm" + new java.util.Date()))
	readFileProxy(file, sc=>println(sc.nextLine()))
}

