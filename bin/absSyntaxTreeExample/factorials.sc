package absSyntaxTreeExample

object factorials {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def multiplyList(list:List[Double]) : Double = list match {
  case Nil => 0
  case x::Nil => x
  case x::xs => x* multiplyList(xs)
  
  }                                               //> multiplyList: (list: List[Double])Double
  
  multiplyList (List(1,2,3,4))                    //> res0: Double = 24.0
  
  def factorial(n:Int):Int = {
  if (n<=2) n
  else n* factorial (n-1)
  }                                               //> factorial: (n: Int)Int
  
  def factorialTail(n:Int, acc: Long = 1): Long = {
  if (n <= 0) acc else factorialTail(n-1, acc * n)
  }                                               //> factorialTail: (n: Int, acc: Long)Long
  
  factorial(5)                                    //> res1: Int = 120
  factorial(2)                                    //> res2: Int = 2
  factorial(1)                                    //> res3: Int = 1
  factorial(0)                                    //> res4: Int = 0
  
  
  //tail recursion
  // @tailrec
  def factorial1(n: Int, acc: Long=1): Long =
    if (n <= 0)  acc else factorial1(n - 1, acc * n)
                                                  //> factorial1: (n: Int, acc: Long)Long
    
    factorial1(0,1)                               //> res5: Long = 1
    
    def sortList (x:Int, y:Int) : Boolean =  {
    x<y
    }                                             //> sortList: (x: Int, y: Int)Boolean
  
  val unsortedList = List(9,8,7,3,5,6,8,7,5,3,2)  //> unsortedList  : List[Int] = List(9, 8, 7, 3, 5, 6, 8, 7, 5, 3, 2)
  unsortedList.sortWith(sortList)                 //> res6: List[Int] = List(2, 3, 3, 5, 5, 6, 7, 7, 8, 8, 9)
  
}