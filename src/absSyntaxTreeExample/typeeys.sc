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

  def keepGrade(results: Results, gradeBoundary: Int) = {
    results collect { case x => x.foreach(x => x._2 > 70) }
  }                                               //> keepGrade: (results: absSyntaxTreeExample.typeeys.Results, gradeBoundary: In
                                                  //| t)Seq[Unit]

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
  (1 to 5) map (x => 4 to 8)                      //> res0: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Rang
                                                  //| e.Inclusive] = Vector(Range(4, 5, 6, 7, 8), Range(4, 5, 6, 7, 8), Range(4, 
                                                  //| 5, 6, 7, 8), Range(4, 5, 6, 7, 8), Range(4, 5, 6, 7, 8))
  (1 to 5) map (x => 4 to 8 map (y => (x, y)))    //> res1: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Inde
                                                  //| xedSeq[(Int, Int)]] = Vector(Vector((1,4), (1,5), (1,6), (1,7), (1,8)), Vec
                                                  //| tor((2,4), (2,5), (2,6), (2,7), (2,8)), Vector((3,4), (3,5), (3,6), (3,7), 
                                                  //| (3,8)), Vector((4,4), (4,5), (4,6), (4,7), (4,8)), Vector((5,4), (5,5), (5,
                                                  //| 6), (5,7), (5,8)))
  (1 to 5) flatMap (x => 4 to 8 map (y => (x, y)))//> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,4), (1,
                                                  //| 5), (1,6), (1,7), (1,8), (2,4), (2,5), (2,6), (2,7), (2,8), (3,4), (3,5), (
                                                  //| 3,6), (3,7), (3,8), (4,4), (4,5), (4,6), (4,7), (4,8), (5,4), (5,5), (5,6),
                                                  //|  (5,7), (5,8))

  def flatten(listOflist: List[List[Int]]): List[Int] = listOflist match {
    case Nil => Nil
    case list :: otherlists => list ++ flatten(otherlists)
  }                                               //> flatten: (listOflist: List[List[Int]])List[Int]

  val listofLists = List(List(1), List(1, 2, 3, 4), List(5, 6, 7))
                                                  //> listofLists  : List[List[Int]] = List(List(1), List(1, 2, 3, 4), List(5, 6,
                                                  //|  7))

  flatten(listofLists)                            //> res3: List[Int] = List(1, 1, 2, 3, 4, 5, 6, 7)

  def flattenSeq(listOflist: Seq[Seq[Int]]): Seq[Int] = listOflist match {
    case Nil => Nil
    case list +: otherlists => list ++ flattenSeq(otherlists)
  }                                               //> flattenSeq: (listOflist: Seq[Seq[Int]])Seq[Int]
  
  flattenSeq(listofLists)                         //> res4: Seq[Int] = List(1, 1, 2, 3, 4, 5, 6, 7)
}