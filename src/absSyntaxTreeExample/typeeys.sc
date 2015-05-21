package absSyntaxTreeExample

object typeeys {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  type Results = Seq[Portfolio]
  type Portfolio = Seq[Coursework]
  type Coursework = (String, Int)

  var map = Map[Int, Int]()                       //> map  : scala.collection.immutable.Map[Int,Int] = Map()

  def findGrade(results: Results, gradeBoundary: Int): Map[Int, Int] = {
    results.foreach(x => (x.foreach(x => if ((x._2: Int) > gradeBoundary) {
      //case (k: Int, v: Int) => map = map + ((k:Int) -> 1) }
      if (map(x._2) == 0) map = map + (x._2 -> 1)
      else map = map + (x._2 -> map(x._2 + 1))
    })))
    map
  }                                               //> findGrade: (results: absSyntaxTreeExample.typeeys.Results, gradeBoundary: In
                                                  //| t)Map[Int,Int]

  //  def keepGrade(results: Results, gradeBoundary: Int) = {
  //   results collect {case x.foreach (x=>x._2 >70) }
  //  }

  // def keepGrade(portfolio: Portfolio):Int = {
  // portfolio.foreach(x => collect{case i:Int => i > 70})
  // }

  def avgCourseworkMark(results: Results): Int = {
    var scores = List()
    results.foreach(x => (x.foreach(x => (scores :: List(x._2)))))
    (scores.fold(0)(_ + _)) / scores.length
  }                                               //> avgCourseworkMark: (results: absSyntaxTreeExample.typeeys.Results)Int

  def partitionGroups(results: Results) = {
    results.foreach(x => x partition (x => x._2 > avgCourseworkMark(results)))
  }                                               //> partitionGroups: (results: absSyntaxTreeExample.typeeys.Results)Unit

  def avgMark(portfolio: Portfolio): Int = {
    portfolio.map(x => x._2).sum / portfolio.length
    //or
    portfolio.map { case x => x._2 }.sum / portfolio.length
  }                                               //> avgMark: (portfolio: absSyntaxTreeExample.typeeys.Portfolio)Int
}