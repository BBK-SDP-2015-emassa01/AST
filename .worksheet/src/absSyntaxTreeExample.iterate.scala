package absSyntaxTreeExample

object iterate {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(127); 

  def iterate[T](x: T, f: T => T): Stream[T] = {
    x #:: iterate(f(x), f)
  };System.out.println("""iterate: [T](x: T, f: T => T)Stream[T]""");$skip(648); 
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
  };System.out.println("""mergings: (alist: List[Int])List[Int]""");$skip(57); 

  val thisCrapList = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4);System.out.println("""thisCrapList  : List[Int] = """ + $show(thisCrapList ));$skip(25); val res$0 = 
  mergings(thisCrapList);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(178); 

  //another way is INSERT SORT ////////////////////////
  def insertHead(list: List[Int]): List[Int] = list match {
  case Nil=> Nil
  case x::xs => sort(x, insertHead(xs))
  };System.out.println("""insertHead: (list: List[Int])List[Int]""");$skip(173); 
  
  def sort(x:Int, thelist: List[Int]): List[Int] = thelist match {
  case List() => List(x)
  case headx::xs => if (x < headx) x :: thelist else headx :: sort(x, xs)
  };System.out.println("""sort: (x: Int, thelist: List[Int])List[Int]""");$skip(39); 
  
  println(insertHead(thisCrapList));$skip(107); 
////////////////////////

  def factorial(n: Int): Int = {
    if (n == 0) 1 else n * factorial(n - 1)
  };System.out.println("""factorial: (n: Int)Int""");$skip(15); val res$1 = 
  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(186); 

  def factorialTailRec(n: Int): Int = {
    def helper(n: Int, acc: Int): Int = {
      if (n == 0) acc else helper((n - 1), acc * n) //acc is now acc * n!!!
    }
    helper(n, 1)
  };System.out.println("""factorialTailRec: (n: Int)Int""");$skip(23); val res$2 = 

  factorialTailRec(5);System.out.println("""res2: Int = """ + $show(res$2));$skip(278); 
  
  
////////////////////////
  def scaleTheList(list: List[Int], factor: Int): List[Int] = list match {
    //using map:
    //list map (x=> x * factor)

    //using pattern matching
    case Nil => Nil
    case head :: tail => head * factor :: scaleTheList(tail, factor)
  };System.out.println("""scaleTheList: (list: List[Int], factor: Int)List[Int]""");$skip(33); val res$3 = 

  scaleTheList(thisCrapList, 4);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(260); 

  def scaleListRecurr(list: List[Int], factor: Int): List[Int] = {
    def helper(list: List[Int], acc: List[Int]): List[Int] = list match {
      case Nil => Nil
      case x :: xs => helper(x * factor :: acc, xs)

    }
    helper(list, List()).reverse
  };System.out.println("""scaleListRecurr: (list: List[Int], factor: Int)List[Int]""");$skip(279); 
  
////////////////////////
  def filterPosElements(ls: List[Int]): List[Int] = ls match {
    case Nil => Nil
    case x :: xs => if (x > 0) x :: filterPosElements(xs) else filterPosElements(xs)
    //could also use
    // ls filter (x => x>0)
    // ls filterNot (x=> x<0)
  };System.out.println("""filterPosElements: (ls: List[Int])List[Int]""");$skip(25); 

  println(thisCrapList);$skip(62); 
  println(thisCrapList partition (x => x > 4));$skip(47);  // single pass
  println(thisCrapList takeWhile (x => x < 4));$skip(47); 
  println(thisCrapList dropWhile (x => x > 2));$skip(42); 
  println(thisCrapList span (x => x > 5));$skip(151); 
////////////////////////
//method to sum up values in a list

def sum (list: List[Int]) : Int = list match{
case Nil => 0
case x::xs =>  x + sum(xs)
};System.out.println("""sum: (list: List[Int])Int""");$skip(21); val res$4 = 
sum(List(1,2,3,4,5));System.out.println("""res4: Int = """ + $show(res$4));$skip(67); val res$5 = 

//reduce and fold
//sum and prod
0::thisCrapList reduceLeft (_+_);System.out.println("""res5: Int = """ + $show(res$5));$skip(33); val res$6 = 
1::thisCrapList reduceLeft (_*_);System.out.println("""res6: Int = """ + $show(res$6));$skip(29); val res$7 = 

(thisCrapList fold 0) (_+_);System.out.println("""res7: Int = """ + $show(res$7));$skip(28); val res$8 = 
(thisCrapList fold 1) (_*_);System.out.println("""res8: Int = """ + $show(res$8));$skip(29); val res$9 = 

thisCrapList ++thisCrapList;System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(61); val res$10 = 
//init = all elements apart from the last!
thisCrapList.init;System.out.println("""res10: List[Int] = """ + $show(res$10))}



}
