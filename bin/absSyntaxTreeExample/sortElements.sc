package absSyntaxTreeExample

object sortElements {
  val list = List(("a", "b", "c"), ("d", "e"), ("f", "g", "h"), ("d", "e"),
    ("i", "j", "k", "l"), ("m", "n"), ("o"))      //> list  : List[java.io.Serializable] = List((a,b,c), (d,e), (f,g,h), (d,e), (i
                                                  //| ,j,k,l), (m,n), o)

  val list2 = List(3, 2, 3, 2, 4, 2, 1)           //> list2  : List[Int] = List(3, 2, 3, 2, 4, 2, 1)

  def lenf(alist: List[java.io.Serializable]): Int = alist match {
    case Nil => 0
    case a :: Nil => 1
    case a :: b => 1 + lenf(b)

  }                                               //> lenf: (alist: List[java.io.Serializable])Int

  lenf(list)                                      //> res0: Int = 7

  ///////////
  // THIS METHOD ONLY MERGES TWO SORTED LISTS. DOES NOT TAKE IN 'THIS CRAP LIST' BECAUSE IT IS NOT SORTED.
  val thisCrapList = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4)
                                                  //> thisCrapList  : List[Int] = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4)
  val l1 = List(1, 4, 7, 10)                      //> l1  : List[Int] = List(1, 4, 7, 10)
  val l2 = List(2, 3, 5, 7, 12, 16)               //> l2  : List[Int] = List(2, 3, 5, 7, 12, 16)

  def merge[T](alist: List[T], blist: List[T])(cmp: (T, T) => Boolean): List[T] = {
    def mergeHelper(AL: List[T], BL: List[T], accList: List[T]): List[T] = (AL, BL) match {
      case (Nil, _) => accList.reverse ++ BL //this also takes care of when both lists are Nil (i.e., any)
      case (_, Nil) => accList.reverse ++ AL
      case (x :: xs, y :: ys) =>
        if (cmp(x, y)) mergeHelper(BL, xs, x :: accList)
        else mergeHelper(ys, AL, y :: accList)

    }
    mergeHelper(alist, blist, Nil)
  }                                               //> merge: [T](alist: List[T], blist: List[T])(cmp: (T, T) => Boolean)List[T]

  merge(l1, l2)((x, y) => x <= y)                 //> res1: List[Int] = List(1, 2, 3, 4, 5, 7, 7, 10, 12, 16)

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
  }                                               //> mergeKeiths: [T](aList: List[T], bList: List[T])(cmp: (T, T) => Boolean)Lis
                                                  //| t[T]
  mergeKeiths(l1, l2)((x, y) => x <= y)           //> res2: List[Int] = List(1, 2, 3, 4, 5, 7, 7, 10, 12, 16)

  /*
  def OKletsDoTheWholeThing[T](list: List[T]): List[T] = {
    val n = list.length / 2
    if (n == 0) list else {
      val (first, second) = list splitAt (n)
      def merge[T](alist: List[T], blist: List[T])(cmp: (T, T) => Boolean): List[T] = {
        def mergeHelper(first: List[T], second: List[T], accList: List[T]): List[T] = (first, second) match {
          case (Nil, _) => accList.reverse ++ second //this also takes care of when both lists are Nil (i.e., any)
          case (_, Nil) => accList.reverse ++ first
          case (x :: xs, y :: ys) =>
            if (cmp(x, y)) mergeHelper(second, xs, x :: accList)
            else mergeHelper(ys, first, y :: accList)
        }
        mergeHelper(alist, blist, Nil)
     
     }
     }
     }*/
     
     def factorise(theSeq1: Seq[Double], theSeq2: Seq[Double], factor: Double): Seq[Double] = theSeq1 match{
     case x :: xs => (x * factor) +: factorise(xs, theSeq2, factor)
     }                                            //> factorise: (theSeq1: Seq[Double], theSeq2: Seq[Double], factor: Double)Seq[
                                                  //| Double]
     
     val Seq1 = Seq (1,2,3,4,5)                   //> Seq1  : Seq[Int] = List(1, 2, 3, 4, 5)
     val Seq2 = Seq (1,2,3,4,5)                   //> Seq2  : Seq[Int] = List(1, 2, 3, 4, 5)
     
     Seq1 ++ Seq2                                 //> res3: Seq[Int] = List(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
     
     
     }