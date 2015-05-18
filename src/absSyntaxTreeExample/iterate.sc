package absSyntaxTreeExample

object iterate {

  def iterate[T](x: T, f: T => T): Stream[T] = {
    x #:: iterate(f(x), f)
  }                                               //> iterate: [T](x: T, f: T => T)Stream[T]
////////////////////////
  def mergings(alist: List[Int]): List[Int] = {
    val n = alist.length / 2
    if (n == 0) alist
    else {
      def concatOrd(xs: List[Int], ys: List[Int]): List[Int] = {
        xs match {
          case Nil => ys
          case xsh :: xst =>
            ys match {
              case Nil => xs
              case ysh :: yst => if (ysh.compareTo(xsh) < 0) ysh :: concatOrd(xs, yst) //for generics use x.compareTo(y)
              else xsh :: concatOrd(xst, ys)
            }
        }
      }
      val (alistFirst, alistSecond) = alist splitAt n
      concatOrd(mergings(alistFirst), mergings(alistSecond))
    }
  }                                               //> mergings: (alist: List[Int])List[Int]

  val thisCrapList = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4)
                                                  //> thisCrapList  : List[Int] = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4)
  mergings(thisCrapList)                          //> res0: List[Int] = List(1, 2, 2, 4, 4, 5, 5, 6, 7, 9)

  //another way is INSERT SORT ////////////////////////
  def insertHead(list: List[Int]): List[Int] = list match {
  case Nil=> Nil
  case x::xs => sort(x, insertHead(xs))
  }                                               //> insertHead: (list: List[Int])List[Int]
  
  def sort(x:Int, thelist: List[Int]): List[Int] = thelist match {
  case List() => List(x)
  case headx::xs => if (x < headx) x :: thelist else headx :: sort(x, xs)
  }                                               //> sort: (x: Int, thelist: List[Int])List[Int]
  
  println(insertHead(thisCrapList))               //> List(1, 2, 2, 4, 4, 5, 5, 6, 7, 9)
////////////////////////

  def factorial(n: Int): Int = {
    if (n == 0) 1 else n * factorial(n - 1)
  }                                               //> factorial: (n: Int)Int
  factorial(5)                                    //> res1: Int = 120

  def factorialTailRec(n: Int): Int = {
    def helper(n: Int, acc: Int): Int = {
      if (n == 0) acc else helper((n - 1), acc * n) //acc is now acc * n!!!
    }
    helper(n, 1)
  }                                               //> factorialTailRec: (n: Int)Int

  factorialTailRec(5)                             //> res2: Int = 120
  
  
////////////////////////
  def scaleTheList(list: List[Int], factor: Int): List[Int] = list match {
    //using map:
    //list map (x=> x * factor)

    //using pattern matching
    case Nil => Nil
    case head :: tail => head * factor :: scaleTheList(tail, factor)
  }                                               //> scaleTheList: (list: List[Int], factor: Int)List[Int]

  scaleTheList(thisCrapList, 4)                   //> res3: List[Int] = List(4, 8, 20, 16, 8, 24, 36, 28, 20, 16)

  def scaleListRecurr(list: List[Int], factor: Int): List[Int] = {
    def helper(list: List[Int], acc: List[Int]): List[Int] = list match {
      case Nil => Nil
      case x :: xs => helper(x * factor :: acc, xs)

    }
    helper(list, List()).reverse
  }                                               //> scaleListRecurr: (list: List[Int], factor: Int)List[Int]
  
////////////////////////
  def filterPosElements(ls: List[Int]): List[Int] = ls match {
    case Nil => Nil
    case x :: xs => if (x > 0) x :: filterPosElements(xs) else filterPosElements(xs)
    //could also use
    // ls filter (x => x>0)
    // ls filterNot (x=> x<0)
  }                                               //> filterPosElements: (ls: List[Int])List[Int]

  println(thisCrapList)                           //> List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4)
  println(thisCrapList partition (x => x > 4)) // single pass
                                                  //> (List(5, 6, 9, 7, 5),List(1, 2, 4, 2, 4))
  println(thisCrapList takeWhile (x => x < 4))    //> List(1, 2)
  println(thisCrapList dropWhile (x => x > 2))    //> List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4)
  println(thisCrapList span (x => x > 5))         //> (List(),List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4))
////////////////////////
//method to sum up values in a list

def sum (list: List[Int]) : Int = list match{
case Nil => 0
case x::xs =>  x + sum(xs)
}                                                 //> sum: (list: List[Int])Int
sum(List(1,2,3,4,5))                              //> res4: Int = 15

//reduce and fold
//sum and prod
0::thisCrapList reduceLeft (_+_)                  //> res5: Int = 45
1::thisCrapList reduceLeft (_*_)                  //> res6: Int = 604800

(thisCrapList fold 0) (_+_)                       //> res7: Int = 45
(thisCrapList fold 1) (_*_)                       //> res8: Int = 604800

thisCrapList ++thisCrapList                       //> res9: List[Int] = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4, 1, 2, 5, 4, 2, 6, 9, 7
                                                  //| , 5, 4)
//init = all elements apart from the last!
thisCrapList.init                                 //> res10: List[Int] = List(1, 2, 5, 4, 2, 6, 9, 7, 5)



}