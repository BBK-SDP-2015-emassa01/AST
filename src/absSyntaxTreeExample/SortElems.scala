package absSyntaxTreeExample

object SortElems extends App {

  def lsort[A](list: List[List[A]]): List[List[A]] = {
    val n = list.length / 2
    if (n == 0) list
    else {
      val (first, second) = list splitAt n
      def merge(first: List[List[A]], second: List[List[A]]): List[List[A]] = (first, second) match {
        case (Nil, Nil) => List()
        case (Nil, second) => second
        case (first, Nil) => first
        case (fh :: ft, sh :: st) =>
          if (fh.length > sh.length) sh :: merge(st, first)
          else fh :: merge(ft, second)
      }
      merge(lsort(first), lsort(second))
    }
  }

  val thisCrapList = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4).sortWith(hashfunc)

  def hashfunc(a: Int, b: Int) = {
    a * 100 / 2 > b * 100
  }

  println(thisCrapList)

  val list = List(("a", "b", "c"), ("d", "e"), ("f", "g", "h"), ("d", "e"),
    ("i", "j", "k", "l"), ("m", "n"), ("o"))
    
    list map (x=> list.length)
  
  thisCrapList.sortWith{_ < _}
    
}

