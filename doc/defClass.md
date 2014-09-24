#define class elements
- 定义类内的函数
```
class Person(val firstName: String, val lastName: String)
{
  private var _age = 0
  def func :()=>String = ()=>firstName //get
  //equal to
  def func2 :String = firstName //get
  //equal to 
  def func3 = firstName //get
  //with parameter
  def func4(newAge: Int) = _age = newAge //set
  //won't compile
  //def func4 = (newAge:Int) = _age = newAge
  def func5 = _age
}
object DefClass extends Application {
  val obama: Person = new Person("sad", "obama")
  println(obama.func2)
  println(obama.func3)
  obama.func4(12)
  println(obama.func5)
}
```
