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
  println(insertHead(thisCrapList))}
}
