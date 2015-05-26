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
  };System.out.println("""findGrade: (results: absSyntaxTreeExample.typeeys.Results, gradeBoundary: Int)Map[Int,Int]""");$skip(123); 

  def keepGrade(results: Results, gradeBoundary: Int) = {
    results collect { case x => x.foreach(x => x._2 > 70) }
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
  };System.out.println("""avgMark: (portfolio: absSyntaxTreeExample.typeeys.Portfolio)Int""");$skip(29); val res$0 = 
  (1 to 5) map (x => 4 to 8);System.out.println("""res0: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Range.Inclusive] = """ + $show(res$0));$skip(47); val res$1 = 
  (1 to 5) map (x => 4 to 8 map (y => (x, y)));System.out.println("""res1: scala.collection.immutable.IndexedSeq[scala.collection.immutable.IndexedSeq[(Int, Int)]] = """ + $show(res$1));$skip(51); val res$2 = 
  (1 to 5) flatMap (x => 4 to 8 map (y => (x, y)));System.out.println("""res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$2));$skip(159); 

  def flatten(listOflist: List[List[Int]]): List[Int] = listOflist match {
    case Nil => Nil
    case list :: otherlists => list ++ flatten(otherlists)
  };System.out.println("""flatten: (listOflist: List[List[Int]])List[Int]""");$skip(68); 

  val listofLists = List(List(1), List(1, 2, 3, 4), List(5, 6, 7));System.out.println("""listofLists  : List[List[Int]] = """ + $show(listofLists ));$skip(24); val res$3 = 

  flatten(listofLists);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(162); 

  def flattenSeq(listOflist: Seq[Seq[Int]]): Seq[Int] = listOflist match {
    case Nil => Nil
    case list +: otherlists => list ++ flattenSeq(otherlists)
  };System.out.println("""flattenSeq: (listOflist: Seq[Seq[Int]])Seq[Int]""");$skip(29); val res$4 = 
  
  flattenSeq(listofLists);System.out.println("""res4: Seq[Int] = """ + $show(res$4))}
}
