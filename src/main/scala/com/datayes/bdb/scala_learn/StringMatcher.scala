package com.datayes.bdb.scala_learn

/**
 * Created by zhoujimin on 14-11-19.
 */
object StringMatcher extends App{
  private def files = (new java.io.File(".")).listFiles
  def stringMatcher(matcher :String=> Boolean) =
  {
    for(file <- files if matcher(file.getName)) yield file
  }
  def fileContain(query : String) =
  {
    stringMatcher(_.contains(query))
  }
  def fileTail(query: String) =
  {
    stringMatcher(_.endsWith(query))
  }
  def fileRegex(query: String) =
  {
    stringMatcher(_.matches(query))
  }
  println(fileContain("git").map((x:java.io.File) => x.getName).reduce(_+" "+_))
  for(file <- fileContain("git")) println(file.getName)
}
