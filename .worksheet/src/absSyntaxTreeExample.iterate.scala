package absSyntaxTreeExample

object iterate {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(127); 

  def iterate[T](x: T, f: T => T): Stream[T] = {
    x #:: iterate(f(x), f)
  };System.out.println("""iterate: [T](x: T, f: T => T)Stream[T]""");$skip(36); val res$0 = 
  
  iterate(5, ((x:Int) => (x*x)));System.out.println("""res0: Stream[Int] = """ + $show(res$0));$skip(34); 

  def func(t:Int):Int ={
  t
  };System.out.println("""func: (t: Int)Int""");$skip(131); 

  //iterate and iterated

  def iterated[T](f: T => T): Stream[T=>T] = {
    ((id: T)=> id) #:: iterated(f) map (_ andThen f)
  };System.out.println("""iterated: [T](f: T => T)Stream[T => T]""");$skip(675); 
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
              case ysh :: yst => if (ysh.compareTo(xsh) < 0) ysh :: concatOrd(xs, yst) //for generics use a cmp(x,y) => x<y functon or something.
              else xsh :: concatOrd(xst, ys)
            }
        }
      }
      val (alistFirst, alistSecond) = alist splitAt n
      concatOrd(mergings(alistFirst), mergings(alistSecond))
    }
  };System.out.println("""mergings: (alist: List[Int])List[Int]""");$skip(57); 

  val thisCrapList = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4);System.out.println("""thisCrapList  : List[Int] = """ + $show(thisCrapList ));$skip(25); val res$1 = 
  mergings(thisCrapList);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(185); 

  //another way is INSERT SORT ////////////////////////
  def insertHead(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case x :: xs => sort(x, insertHead(xs))
  };System.out.println("""insertHead: (list: List[Int])List[Int]""");$skip(178); 

  def sort(x: Int, thelist: List[Int]): List[Int] = thelist match {
    case List() => List(x)
    case headx :: xs => if (x < headx) x :: thelist else headx :: sort(x, xs)
  };System.out.println("""sort: (x: Int, thelist: List[Int])List[Int]""");$skip(37); 

  println(insertHead(thisCrapList));$skip(109); 
  ////////////////////////

  def factorial(n: Int): Int = {
    if (n == 0) 1 else n * factorial(n - 1)
  };System.out.println("""factorial: (n: Int)Int""");$skip(15); val res$2 = 
  factorial(5);System.out.println("""res2: Int = """ + $show(res$2));$skip(186); 

  def factorialTailRec(n: Int): Int = {
    def helper(n: Int, acc: Int): Int = {
      if (n == 0) acc else helper((n - 1), acc * n) //acc is now acc * n!!!
    }
    helper(n, 1)
  };System.out.println("""factorialTailRec: (n: Int)Int""");$skip(23); val res$3 = 

  factorialTailRec(5);System.out.println("""res3: Int = """ + $show(res$3));$skip(275); 

  ////////////////////////
  def scaleTheList(list: List[Int], factor: Int): List[Int] = list match {
    //using map:
    //list map (x=> x * factor)

    //using pattern matching
    case Nil => Nil
    case head :: tail => head * factor :: scaleTheList(tail, factor)
  };System.out.println("""scaleTheList: (list: List[Int], factor: Int)List[Int]""");$skip(33); val res$4 = 

  scaleTheList(thisCrapList, 4);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(260); 

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
  println(thisCrapList span (x => x > 5));$skip(167); 
  ////////////////////////
  //method to sum up values in a list

  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case x :: xs => x + sum(xs)
  };System.out.println("""sum: (list: List[Int])Int""");$skip(27); val res$5 = 
  sum(List(1, 2, 3, 4, 5));System.out.println("""res5: Int = """ + $show(res$5));$skip(77); val res$6 = 

  //reduce and fold
  //sum and prod
  0 :: thisCrapList reduceLeft (_ + _);System.out.println("""res6: Int = """ + $show(res$6));$skip(39); val res$7 = 
  1 :: thisCrapList reduceLeft (_ * _);System.out.println("""res7: Int = """ + $show(res$7));$skip(32); val res$8 = 

  (thisCrapList fold 0)(_ + _);System.out.println("""res8: Int = """ + $show(res$8));$skip(31); val res$9 = 
  (thisCrapList fold 1)(_ * _);System.out.println("""res9: Int = """ + $show(res$9));$skip(32); val res$10 = 

  thisCrapList ++ thisCrapList;System.out.println("""res10: List[Int] = """ + $show(res$10));$skip(65); val res$11 = 
  //init = all elements apart from the last!
  thisCrapList.init;System.out.println("""res11: List[Int] = """ + $show(res$11));$skip(221); 

  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  };System.out.println("""pack: [A](ls: List[A])List[List[A]]""");$skip(93); 

  def encode[A](ls: List[A]): List[(Int, A)] =
    pack(ls) map { e => (e.length, e.head) };System.out.println("""encode: [A](ls: List[A])List[(Int, A)]""");$skip(118); 

  val thisCrapList2 = List(List(1, 2, 3, 4), 2, 5, 4, List(1, 2, 3, 4), List(1, 2, 3, 4), 9, List(1, 2, 3, 4), 5, 4);System.out.println("""thisCrapList2  : List[Any] = """ + $show(thisCrapList2 ));$skip(22); val res$12 = 
  pack(thisCrapList2);System.out.println("""res12: List[List[Any]] = """ + $show(res$12));$skip(122); 

  val list = List(("a", "b", "c"), ("d", "e"), ("f", "g", "h"), ("d", "e"),
    ("i", "j", "k", "l"), ("m", "n"), ("o"));System.out.println("""list  : List[java.io.Serializable] = """ + $show(list ));$skip(40); val res$13 = 

  list map (x => (x, list.indexOf(x)));System.out.println("""res13: List[(java.io.Serializable, Int)] = """ + $show(res$13));$skip(32); val res$14 = 

  thisCrapList.sortWith(_ < _);System.out.println("""res14: List[Int] = """ + $show(res$14));$skip(250); 

  ////////////////////////
  
  // three args are passed in:
// 1) 'f' - a function that takes an Int and returns an Int
// 2) 'a' - an Int
// 3) 'b' - an Int
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f, a + 1, b);System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(99); 
 
// these three functions use the sum() function
def sumInts(a: Int, b: Int): Int = sum(id, a, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(56); 
def sumSquares(a: Int, b: Int): Int = sum(square, a, b);System.out.println("""sumSquares: (a: Int, b: Int)Int""");$skip(64); 
def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b);System.out.println("""sumPowersOfTwo: (a: Int, b: Int)Int""");$skip(85); 
 
// three functions that are passed into the sum() function
def id(x: Int): Int = x;System.out.println("""id: (x: Int)Int""");$skip(32); 
def square(x: Int): Int = x * x;System.out.println("""square: (x: Int)Int""");$skip(71); 
def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1);System.out.println("""powerOfTwo: (x: Int)Int""");$skip(83); 
 
// this simply prints the number 10
println("sum ints 1 to 4 = " + sumInts(1,4))}

}
