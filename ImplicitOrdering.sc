object ImplicitOrdering {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
def mergesortOrd[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = xs match {
        case Nil => ys
        case hd :: tl =>
          ys match {
            case Nil => xs
            case hd1 :: tl1 =>
              if (ord.lt(hd, hd1)) hd :: merge(tl, ys)
              else hd1 :: merge(xs, tl1)
          }
      }
      val (first, second) = xs splitAt n
      merge(mergesortOrd(first)(ord), mergesortOrd(second)(ord))
    }
  }                                               //> mergesortOrd: [T](xs: List[T])(ord: Ordering[T])List[T]

  println(mergesortOrd(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9))(Ordering.Int))
                                                  //> List(2, 4, 4, 8, 9, 9, 12, 12, 56, 678)
  println(mergesortOrd(List("apple", "pear", "orange", "pineapple"))(Ordering.String))
                                                  //> List(apple, orange, pear, pineapple)

  def mergesortOrdImp[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = xs match {
        case Nil => ys
        case hd :: tl =>
          ys match {
            case Nil => xs
            case hd1 :: tl1 =>
              if (ord.lt(hd, hd1)) hd :: merge(tl, ys)
              else hd1 :: merge(xs, tl1)
          }
      }
      val (first, second) = xs splitAt n
      merge(mergesortOrdImp(first), mergesortOrdImp(second))
    }
  }                                               //> mergesortOrdImp: [T](xs: List[T])(implicit ord: Ordering[T])List[T]
  

  println(mergesortOrdImp(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9)))
                                                  //> List(2, 4, 4, 8, 9, 9, 12, 12, 56, 678)
  println(mergesortOrdImp(List("apple", "pear", "orange", "pineapple")))
                                                  //> List(apple, orange, pear, pineapple)

  def mergeMore[T] (list:List[T])(implicit ord: Ordering[T]) : List[T] = {
  val n = list.length/2
  if (n<=0) list
  else{
  val (first,second) = list splitAt n
  
  def sort(list:List[T], list2: List[T]) : List[T] = (list, list2) match {
  case (Nil, Nil) => Nil
  case (list, Nil) => list
  case (Nil, list2) => list2
  case ((ss::sss),(tt::ttt)) => if (ord.gteq(ss, tt)) ss:: sort(sss, list2) else tt::sort(list, ttt)
  }

  sort(mergeMore(first), mergeMore(second))
  }
  }                                               //> mergeMore: [T](list: List[T])(implicit ord: Ordering[T])List[T]

  println(mergeMore(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9)))
                                                  //> List(678, 56, 12, 12, 9, 9, 8, 4, 4, 2)


def factHelper(n:Int):Long = {
def helper(n:Int, acc:Int):Long = {
if (n<=0) acc else helper (n-1, n*acc)
}
helper(n, 1)
}                                                 //> factHelper: (n: Int)Long

factHelper(5)                                     //> res0: Long = 120


}