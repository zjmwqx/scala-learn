package com.datayes.bdb.scala_learn

import ProgramTest.Element.elem
object ProgramTest {
  abstract class Element{
    def contents: Array[String]
    def width: Int = contents(0).length
    def height: Int = contents.length
    def above(that: Element) ={
      elem(this.contents ++ that.contents)
    }
    def beside(that: Element) : Element ={
      elem(
      for(
        (xs, ys) <- this.contents zip that.contents
      ) yield xs + ys
      )
    }
  }


  object Element{
    private class ArrayElement(val contents: Array[String]) extends Element {

    }
    def elem(contents: Array[String]) : Element = {
      new ArrayElement(contents)
    }
  }


}
