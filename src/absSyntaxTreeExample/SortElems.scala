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

  list map (x => list.length)

  thisCrapList.sortWith { _ < _ }
  val l1 = List(1, 4, 7, 10)
  val l2 = List(2, 3, 5, 7, 12, 16)
  def merge[T](alist: List[T], blist: List[T])(cmp: (T, T) => Boolean): List[T] = {
    def mergeHelper(AL: List[T], BL: List[T], accList: List[T]): List[T] = (AL, BL) match {
      case (Nil, _) => accList.reverse ++ BL //this also takes care of when both lists are Nil (i.e., any)
      case (_, Nil) => accList.reverse ++ AL
      case (x :: xs, y :: ys) =>
        if (cmp(x, y)) mergeHelper(BL, xs, x :: accList)
        else mergeHelper(ys, AL, y :: accList)
      
    }
    mergeHelper(alist, blist, Nil)
  }

  merge(l1, l2)((x, y) => x <= y)

  def mergeKeiths[T](aList: List[T], bList: List[T])(cmp: (T, T) => Boolean): List[T] = {
    def mergeHelper2(aL: List[T], bL: List[T], accList: List[T]): List[T] = (aL, bL) match {
      case (Nil, _) => accList ++ bL // could use reverse on accList
      case (_, Nil) => accList ++ aL // to save space (and time?)
      case (x :: xs, y :: ys) => {
        if (cmp(x, y)) mergeHelper2(xs, bL, accList :+ x)
        else mergeHelper2(aL, ys, accList :+ y)
      }
    }
    mergeHelper2(aList, bList, Nil)
  }
  mergeKeiths(l1, l2)((x, y) => x <= y)
}

