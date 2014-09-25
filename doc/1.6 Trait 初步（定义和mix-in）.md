##Trait is interface with function
- Traits就像是有函数体的Interface。可以和class互相依賴，第一個依賴用extends，第二個之後用with。
```
trait JsonAble {
  def toJson() =
    scala.util.parsing.json.JSONFormat.defaultFormatter(this)
}
class OneClass extends JsonAble{}

trait OneTrait extends OneClass with ForEachAble[Int]{}
```

- 下面这个例子是给java.util.ArrayList添加了foreach的功能。**相當於定義了匿名類繼承ArrayList和ForEachAble**
- **聲明在一個類中，定義在另一個類,跨類調用**
```
trait ForEachAble[A] {
  def iterator: java.util.Iterator[A] //interface function,聲明在一個類中，定義在另一個類,跨類調用

  //def iterator():java.util.Iterator[A] this is also OK
  //def iterator:()=>java.util.Iterator[A] should call with iterator(), 匿名函數和函數得不同
  def foreach(f: A => Unit) = {
    val iter = iterator
    while (iter.hasNext)
      f(iter.next)
  }
}
object TraitDemo extends Application {
  val list = new **java.util.ArrayList[Int]() with ForEachAble[Int]**
  //var value = new Set[Int] with ForEachAble[Int]
  list.add(3); list.add(2)
  println("For each: ");
  list.foreach(x => println(x))
}
```

