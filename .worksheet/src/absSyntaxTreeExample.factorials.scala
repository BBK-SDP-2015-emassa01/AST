package absSyntaxTreeExample

object factorials {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  println("Welcome to the Scala worksheet");$skip(146); 
  
  
  def multiplyList(list:List[Double]) : Double = list match {
  case Nil => 0
  case x::Nil => x
  case x::xs => x* multiplyList(xs)
  
  };System.out.println("""multiplyList: (list: List[Double])Double""");$skip(34); val res$0 = 
  
  multiplyList (List(1,2,3,4));System.out.println("""res0: Double = """ + $show(res$0));$skip(78); 
  
  def factorial(n:Int):Int = {
  if (n<=2) n
  else n* factorial (n-1)
  };System.out.println("""factorial: (n: Int)Int""");$skip(110); 
  
  def factorialTail(n:Int, acc: Long = 1): Long = {
  if (n <= 0) acc else factorialTail(n-1, acc * n)
  };System.out.println("""factorialTail: (n: Int, acc: Long)Long""");$skip(18); val res$1 = 
  
  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(15); val res$2 = 
  factorial(2);System.out.println("""res2: Int = """ + $show(res$2));$skip(15); val res$3 = 
  factorial(1);System.out.println("""res3: Int = """ + $show(res$3));$skip(15); val res$4 = 
  factorial(0);System.out.println("""res4: Int = """ + $show(res$4));$skip(138); 
  
  
  //tail recursion
  // @tailrec
  def factorial1(n: Int, acc: Long=1): Long =
    if (n <= 0)  acc else factorial1(n - 1, acc * n);System.out.println("""factorial1: (n: Int, acc: Long)Long""");$skip(25); val res$5 = 
    
    factorial1(0,1);System.out.println("""res5: Long = """ + $show(res$5));$skip(66); 
    
    def sortList (x:Int, y:Int) : Boolean =  {
    x<y
    };System.out.println("""sortList: (x: Int, y: Int)Boolean""");$skip(52); 
  
  val unsortedList = List(9,8,7,3,5,6,8,7,5,3,2);System.out.println("""unsortedList  : List[Int] = """ + $show(unsortedList ));$skip(34); val res$6 = 
  unsortedList.sortWith(sortList);System.out.println("""res6: List[Int] = """ + $show(res$6))}
  
}
