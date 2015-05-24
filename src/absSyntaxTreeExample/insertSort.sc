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
  
  
  def reverseList[T] (list: List[T]) : List[T] = list match {
  case Nil => Nil
  case s::Nil => List(s)
  case s::ss => ss.last :: reverseList(ss.take(ss.length-1)) ++ List(s)
  }                                               //> reverseList: [T](list: List[T])List[T]
  
  val forwardList = List(1,2,3,4,5,6,7,8,9,10)    //> forwardList  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  reverseList(forwardList)                        //> res0: List[Int] = List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
  
  def productOfVectors (a:Vector[Double], b:Vector[Double]) : Double = {
  (a zip b map (ab => ab._1*ab._1)).sum
  }                                               //> productOfVectors: (a: Vector[Double], b: Vector[Double])Double
  
  def productOfVectors2 (a:Vector[Double], b:Vector[Double]) : Double = {
  (a zip b map {case (x,y) => x*y}).sum
  }                                               //> productOfVectors2: (a: Vector[Double], b: Vector[Double])Double
  
  def partit(list:List[Int]): (List[Int], List[Int]) = {
  val x = list.filter(x => x <= 5)
  val y = list.filter(x => x > 5)
  (x,y)
  }                                               //> partit: (list: List[Int])(List[Int], List[Int])
  
}