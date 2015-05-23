package absSyntaxTreeExample

object typeeys {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(90); 
  println("Welcome to the Scala worksheet")

  type Results = Seq[Portfolio]
  type Portfolio = Seq[Coursework]
  type Coursework = (String, Int);$skip(131); 

  var map = Map[Int, Int]();System.out.println("""map  : scala.collection.immutable.Map[Int,Int] = """ + $show(map ));$skip(330); 

  def findGrade(results: Results, gradeBoundary: Int): Map[Int, Int] = {
    results.foreach(x => (x.foreach(x => if ((x._2: Int) > gradeBoundary) {
      //case (k: Int, v: Int) => map = map + ((k:Int) -> 1) }
      if (map(x._2) == 0) map = map + (x._2 -> 1)
      else map = map + (x._2 -> map(x._2 + 1))
    })))
    map
  };System.out.println("""findGrade: (results: absSyntaxTreeExample.typeeys.Results, gradeBoundary: Int)Map[Int,Int]""");$skip(122); 

   def keepGrade(results: Results, gradeBoundary: Int) = {
    results collect {case x => x.foreach (x=>x._2 >70) }
   };System.out.println("""keepGrade: (results: absSyntaxTreeExample.typeeys.Results, gradeBoundary: Int)Seq[Unit]""");$skip(307); 

  // def keepGrade(portfolio: Portfolio):Int = {
  // portfolio.foreach(x => collect{case i:Int => i > 70})
  // }

  def avgCourseworkMark(results: Results): Int = {
    var scores = List()
    results.foreach(x => (x.foreach(x => (scores :: List(x._2)))))
    (scores.fold(0)(_ + _)) / scores.length
  };System.out.println("""avgCourseworkMark: (results: absSyntaxTreeExample.typeeys.Results)Int""");$skip(128); 

  def partitionGroups(results: Results) = {
    results.foreach(x => x partition (x => x._2 > avgCourseworkMark(results)))
  };System.out.println("""partitionGroups: (results: absSyntaxTreeExample.typeeys.Results)Unit""");$skip(171); 

  def avgMark(portfolio: Portfolio): Int = {
    portfolio.map(x => x._2).sum / portfolio.length
    //or
    portfolio.map { case x => x._2 }.sum / portfolio.length
  };System.out.println("""avgMark: (portfolio: absSyntaxTreeExample.typeeys.Portfolio)Int""")}
}
