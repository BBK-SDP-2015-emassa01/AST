object ImplicitOrdering {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(69); 
  println("Welcome to the Scala worksheet");$skip(549); 
  
  
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
  };System.out.println("""mergesortOrd: [T](xs: List[T])(ord: Ordering[T])List[T]""");$skip(80); 

  println(mergesortOrd(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9))(Ordering.Int));$skip(87); 
  println(mergesortOrd(List("apple", "pear", "orange", "pineapple"))(Ordering.String));$skip(554); 

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
  };System.out.println("""mergesortOrdImp: [T](xs: List[T])(implicit ord: Ordering[T])List[T]""");$skip(72); 
  

  println(mergesortOrdImp(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9)));$skip(73); 
  println(mergesortOrdImp(List("apple", "pear", "orange", "pineapple")));$skip(480); 

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
  };System.out.println("""mergeMore: [T](list: List[T])(implicit ord: Ordering[T])List[T]""");$skip(63); 

  println(mergeMore(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9)));$skip(125); 


def factHelper(n:Int):Long = {
def helper(n:Int, acc:Int):Long = {
if (n<=0) acc else helper (n-1, n*acc)
}
helper(n, 1)
};System.out.println("""factHelper: (n: Int)Long""");$skip(15); val res$0 = 

factHelper(5);System.out.println("""res0: Long = """ + $show(res$0))}


}
