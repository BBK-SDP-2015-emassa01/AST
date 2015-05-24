package absSyntaxTreeExample

object insertSort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  println("Welcome to the Scala worksheet");$skip(185); 

  //another way is INSERT SORT ////////////////////////
  def insertHead(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case x :: xs => sort(x, insertHead(xs))
  };System.out.println("""insertHead: (list: List[Int])List[Int]""");$skip(200); 

  def sort(x: Int, thelist: List[Int]): List[Int] = thelist match {
    case List() => List(x)
    case headx :: remaininglist => if (x < headx) x :: thelist else headx :: sort(x, remaininglist)
  };System.out.println("""sort: (x: Int, thelist: List[Int])List[Int]""");$skip(57); 

  val thisCrapList = List(3, 2, 5, 4, 2, 6, 9, 7, 5, 4);System.out.println("""thisCrapList  : List[Int] = """ + $show(thisCrapList ));$skip(36); 
  println(insertHead(thisCrapList));$skip(187); 
  
  
  def reverseList[T] (list: List[T]) : List[T] = list match {
  case Nil => Nil
  case s::Nil => List(s)
  case s::ss => ss.last :: reverseList(ss.take(ss.length-1)) ++ List(s)
  };System.out.println("""reverseList: [T](list: List[T])List[T]""");$skip(50); 
  
  val forwardList = List(1,2,3,4,5,6,7,8,9,10);System.out.println("""forwardList  : List[Int] = """ + $show(forwardList ));$skip(27); val res$0 = 
  reverseList(forwardList);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(120); 
  
  def productOfVectors (a:Vector[Double], b:Vector[Double]) : Double = {
  (a zip b map (ab => ab._1*ab._1)).sum
  };System.out.println("""productOfVectors: (a: Vector[Double], b: Vector[Double])Double""");$skip(121); 
  
  def productOfVectors2 (a:Vector[Double], b:Vector[Double]) : Double = {
  (a zip b map {case (x,y) => x*y}).sum
  };System.out.println("""productOfVectors2: (a: Vector[Double], b: Vector[Double])Double""");$skip(141); 
  
  def partit(list:List[Int]): (List[Int], List[Int]) = {
  val x = list.filter(x => x <= 5)
  val y = list.filter(x => x > 5)
  (x,y)
  };System.out.println("""partit: (list: List[Int])(List[Int], List[Int])""")}
  
}
