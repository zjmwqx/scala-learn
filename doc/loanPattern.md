#Scala Loan Pattern
- 再一次读到 Scala 中的“贷出模式（LoanPattern）”这个术语，这才比上次稍了解一些。我的理解，此一模式大概是说，对于那些**资源密集**（resource-intensive）型对象的使用应该使用这一模式。

- 使用这一模式的原因是，既然*资源集中在一个对象中*，那么用户代码就不能一直保持着获得的所有资源，而应该在需要时就向资源供给方进行借贷，使用完毕之后立即归还。

- 此外，***Scala 中将函数也是对象，可以像参数那样传递给另一个函数的特征使得贷出模式更加有意义。***客户代码借贷了所需的资源，接下来如何使用这些资源以完成特定的任务则由客户决定。就像我们向银行贷款，这些钱的具体用途是客户决定，也是客户才明确的。

- 对于此类资源，有数据库连接、IO操作等，这些是我们用完则务必立即释放的资源。而且，资源使用完毕业意味着将被自动回收，我们不必操心资源回收的过程。

- 下面的代码使用借贷模式管理资源。（使用SPark的word-vec的输出保存）

```
  def writeFile(fileName: File)(operation: PrintWriter => Unit) {
    val pw = new PrintWriter(fileName) // 贷出资源writer 
    try {
      operation(pw) // 客户使用资源 
    } finally {
      pw.close() // 用完则释放被回收 
    }
  }

  def print2Text(file: File, model: Word2VecModel, wordVec:Word2Vec) {
    writeFile(file) {
      // 使用资源的具体操作 
      writer =>
        writer.println(model.getModel.size)
        writer.println(wordVec.getVectorSize)
        model.getModel.map(x => {writer.print(x._1+" "+
            x._2.map(_.toString).reduceLeft(_+ " " +_))
            writer.println()})
    }
  }
```
