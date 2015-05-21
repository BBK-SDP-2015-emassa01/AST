package absSyntaxTreeExample

object iterate {

  def iterate[T](x: T, f: T => T): Stream[T] = {
    x #:: iterate(f(x), f)
  }
  
  iterate(5, ((x:Int) => (x*x)))
  
  def func(t:Int):Int ={
  t
  }

  //iterate and iterated

  def iterated[T](f: T => T): Stream[T=>T] = {
    ((id: T)=> id) #:: iterated(f) map (_ andThen f)
  }
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
  }

  val thisCrapList = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4)
  mergings(thisCrapList)

  //another way is INSERT SORT ////////////////////////
  def insertHead(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case x :: xs => sort(x, insertHead(xs))
  }

  def sort(x: Int, thelist: List[Int]): List[Int] = thelist match {
    case List() => List(x)
    case headx :: xs => if (x < headx) x :: thelist else headx :: sort(x, xs)
  }

  println(insertHead(thisCrapList))
  ////////////////////////

  def factorial(n: Int): Int = {
    if (n == 0) 1 else n * factorial(n - 1)
  }
  factorial(5)

  def factorialTailRec(n: Int): Int = {
    def helper(n: Int, acc: Int): Int = {
      if (n == 0) acc else helper((n - 1), acc * n) //acc is now acc * n!!!
    }
    helper(n, 1)
  }

  factorialTailRec(5)

  ////////////////////////
  def scaleTheList(list: List[Int], factor: Int): List[Int] = list match {
    //using map:
    //list map (x=> x * factor)

    //using pattern matching
    case Nil => Nil
    case head :: tail => head * factor :: scaleTheList(tail, factor)
  }

  scaleTheList(thisCrapList, 4)

  def scaleListRecurr(list: List[Int], factor: Int): List[Int] = {
    def helper(list: List[Int], acc: List[Int]): List[Int] = list match {
      case Nil => Nil
      case x :: xs => helper(x * factor :: acc, xs)

    }
    helper(list, List()).reverse
  }

  ////////////////////////
  def filterPosElements(ls: List[Int]): List[Int] = ls match {
    case Nil => Nil
    case x :: xs => if (x > 0) x :: filterPosElements(xs) else filterPosElements(xs)
    //could also use
    // ls filter (x => x>0)
    // ls filterNot (x=> x<0)
  }

  println(thisCrapList)
  println(thisCrapList partition (x => x > 4)) // single pass
  println(thisCrapList takeWhile (x => x < 4))
  println(thisCrapList dropWhile (x => x > 2))
  println(thisCrapList span (x => x > 5))
  ////////////////////////
  //method to sum up values in a list

  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case x :: xs => x + sum(xs)
  }
  sum(List(1, 2, 3, 4, 5))

  //reduce and fold
  //sum and prod
  0 :: thisCrapList reduceLeft (_ + _)
  1 :: thisCrapList reduceLeft (_ * _)

  (thisCrapList fold 0)(_ + _)
  (thisCrapList fold 1)(_ * _)

  thisCrapList ++ thisCrapList
  //init = all elements apart from the last!
  thisCrapList.init

  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  def encode[A](ls: List[A]): List[(Int, A)] =
    pack(ls) map { e => (e.length, e.head) }

  val thisCrapList2 = List(List(1, 2, 3, 4), 2, 5, 4, List(1, 2, 3, 4), List(1, 2, 3, 4), 9, List(1, 2, 3, 4), 5, 4)
  pack(thisCrapList2)

  val list = List(("a", "b", "c"), ("d", "e"), ("f", "g", "h"), ("d", "e"),
    ("i", "j", "k", "l"), ("m", "n"), ("o"))

  list map (x => (x, list.indexOf(x)))

  thisCrapList.sortWith(_ < _)

  ////////////////////////
  
  // three args are passed in:
// 1) 'f' - a function that takes an Int and returns an Int
// 2) 'a' - an Int
// 3) 'b' - an Int
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f, a + 1, b)
 
// these three functions use the sum() function
def sumInts(a: Int, b: Int): Int = sum(id, a, b)
def sumSquares(a: Int, b: Int): Int = sum(square, a, b)
def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
 
// three functions that are passed into the sum() function
def id(x: Int): Int = x
def square(x: Int): Int = x * x
def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
 
// this simply prints the number 10
println("sum ints 1 to 4 = " + sumInts(1,4))

}