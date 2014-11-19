package com.datayes.bdb.scala_train

/**
 * Created by zhoujimin on 14-11-9.
 */
abstract class TAction {
  def doAction
}
trait TBeforeAfter extends TAction {
  abstract override def doAction{
    println("/entry before-action")
    super.doAction
    println("/entry after-action")
  }
}
//trait TTwiceAction extends TAction的时候可以在后面调整线性化的顺序,这是和多继承的一个区别
trait TTwiceAction extends TBeforeAfter{//这个时候是没办法调整线性关系的。已经在定义的时候确定,
  abstract override def doAction{
    for (i <-1 to 2) {
      super.doAction
      println("==> No." + i)
    }
  }
}
class RealAction extends TAction{
  def doAction = { println("** real action done ! **")}
}
//特质可以混入，混入的特质中的方法可以动态绑定，必须声明方法abstract override
object ScalaTrait extends App{
  val act1 = new RealAction with TBeforeAfter with TTwiceAction
  act1.doAction
}
