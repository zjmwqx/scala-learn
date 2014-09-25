#case class 的逐漸抽象
- case class 顾名思义就是为case语句专门设计的类：
  在普通类的基础上添加了和类名一直的工厂方法， 还添加了hashcode,equals和toString等方法。
  **下面的例子把算法流程抽象化爲case class,並且利用case調度**
```
object CaseFunction extends Application{
	def fibonacci(in: Any): Int = in match{
	  case 0 => 0
	  case 1 => 1	
	  case n: Int if n > 0 => fibonacci(n-1)+fibonacci(n-2)
	  case _ => 0
	}
	println(fibonacci(4))
	//abstract：抽象出Fibonacci表達式
	case class Fibonacci(n: Int) extends Expr
	{
	  require(n>=0)
	}
	def sumOp(a:Fibonacci, b:Fibonacci): Int = {
	  value_c(a) + value_c(b)
	}
	def value_c(in: Any): Int = in match{
	  case Fibonacci(0) => 0
	  case Fibonacci(1) => 1
	  case Fibonacci(n) => sumOp(Fibonacci(n-1),Fibonacci(n-2))
	  case _ => 0
	}
	println(value_c(Fibonacci(4)))
	//continue abstract：抽象出SumExp表達式
	abstract class Expr
	case class SumExp(a:Expr, b:Expr) extends Expr
	
	def value(in: Any): Int =  in match{
	  case Fibonacci(0) => 0
	  case Fibonacci(1) => 1
	  case Fibonacci(n) => value(SumExp(Fibonacci(n-1), Fibonacci(n-2)))
	  case SumExp(a, b) => value(a) + value(b)
	}
	println(value(Fibonacci(4)))
	
}

```
