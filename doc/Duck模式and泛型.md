#Duck模式：避免继承的不灵活
```
def withClose(closeAble: {def close():Unit})(op:{def close():Unit} =>Unit)
	{
	  try{
	    op(closeAble)
	  }finally
	  {
	    closeAble.close()
	  }
	}
	class Connection{
	  def close() = println("close connection")
	}
	val conn : Connection = new Connection()
	withClose(conn)(conn=>println("do something with Connection"))
```
#Generic（范形）：返回值更加靈活
```
def withClose[A <:{def close():Unit},B](closeAble: A)(op: A =>B): B =
	{
	  try{
	    op(closeAble)
	  }finally{
	    closeAble.close
	  }
	}
	class Connection {
	  def close() = println("close connection")
	}
	val conn = new Connection()
	withClose(conn){
	  conn =>
	    println("do something")
	    "123456"//寫12345也可以
	}
```
