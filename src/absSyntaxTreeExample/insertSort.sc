package absSyntaxTreeExample

object insertSort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //another way is INSERT SORT ////////////////////////
  def insertHead(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case x :: xs => sort(x, insertHead(xs))
  }                                               //> insertHead: (list: List[Int])List[Int]

  def sort(x: Int, thelist: List[Int]): List[Int] = thelist match {
    case List() => List(x)
    case headx :: remaininglist => if (x < headx) x :: thelist else headx :: sort(x, remaininglist)
  }                                               //> sort: (x: Int, thelist: List[Int])List[Int]

  val thisCrapList = List(3, 2, 5, 4, 2, 6, 9, 7, 5, 4)
                                                  //> thisCrapList  : List[Int] = List(3, 2, 5, 4, 2, 6, 9, 7, 5, 4)
  println(insertHead(thisCrapList))               //> List(2, 2, 3, 4, 4, 5, 5, 6, 7, 9)
}