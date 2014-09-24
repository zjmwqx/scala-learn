#word count用函數式編程的幾種寫法：
```
var list = List("warn msg 2003","warn msg 2341","error msg 2332")
```
###寫法一：每個句子count，然後加和
```
def countWord(arr:Array[String])=
{
  arr.count(_=="msg")
}
list.map(_ split " ").map(countWord).reduceLeft(_+_)
```
###寫法二：根據一縮減
```
list.map(_ split " ").map(_.count(_ == "msg")).reduceLeft(_+_)
```
###寫法三：拼接，整體count
```
val ll = list.map(_.split(" ")).map(_.toList).reduceLeft(_:::_).count(_ == "msg")
```
###寫法四：拼接，不用count，用reduce,這裏有個trick,必須先bool2int,如果直接reduceLeft(_.toString, _.toString)會報錯
- **原因是reduce的輸入輸出類型必須保證一致**
```
implicit def bool2int(b:Boolean)= if (b) 1 else 0
val ll = list.map(_.split(" ")).map(_.toList).reduceLeft(_:::_)
println(ll.map(_ == "msg").map(bool2int).reduceLeft(_ + _))
```
