#pass parameter by its name

- 由按值传递修改为按名称传递后将不会产生异常。因为log函数的参数是按名称传递，参数会等到实际使用的时候才会计算，所以被跳过。

- 按名称传递参数可以减少**不必要的**计算和异常。

- 可以用来实现assert, 如果不按照名称调用，按照值调用会使得assert中的语句异常影响正常的执行，这不符合**面向切面**的思想

```
  object CallByName extends Application {
  val isWrong = false
  def func1(msg: String) = {
    if(isWrong) println(msg)
  }
  def func2(msg: => String)={
    if(isWrong) println(msg)
  }
  func2("hello"+ 1/0)
  
  val assertionsEnabled = false
  def boolAssert(pred: =>Boolean) = //傳入的不是值，是函數代碼
  {
    if(assertionsEnabled && !pred)
      throw new AssertionError
  }
  boolAssert(3 / 0 < 2)
  
}

```

- 看上去怪异的语法可以这样理解：
  ```
  def boolAssert(pred: ()=>Boolean) =
  {
    if(assertionsEnabled && !pred)
      throw new AssertionError
  }
  ```
  但是上面的函数调用时需要：
  ```
    boolAssert(()=>3 / 0 < 2)
  ```
  所以省调"()"
