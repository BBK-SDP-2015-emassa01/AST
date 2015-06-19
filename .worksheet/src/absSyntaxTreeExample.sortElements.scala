package absSyntaxTreeExample

object sortElements {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(172); 
  val list = List(("a", "b", "c"), ("d", "e"), ("f", "g", "h"), ("d", "e"),
    ("i", "j", "k", "l"), ("m", "n"), ("o"));System.out.println("""list  : List[java.io.Serializable] = """ + $show(list ));$skip(41); 

  val list2 = List(3, 2, 3, 2, 4, 2, 1);System.out.println("""list2  : List[Int] = """ + $show(list2 ));$skip(145); 

  def lenf(alist: List[java.io.Serializable]): Int = alist match {
    case Nil => 0
    case a :: Nil => 1
    case a :: b => 1 + lenf(b)

  };System.out.println("""lenf: (alist: List[java.io.Serializable])Int""");$skip(14); val res$0 = 

  lenf(list);System.out.println("""res0: Int = """ + $show(res$0));$skip(178); 

  ///////////
  // THIS METHOD ONLY MERGES TWO SORTED LISTS. DOES NOT TAKE IN 'THIS CRAP LIST' BECAUSE IT IS NOT SORTED.
  val thisCrapList = List(1, 2, 5, 4, 2, 6, 9, 7, 5, 4);System.out.println("""thisCrapList  : List[Int] = """ + $show(thisCrapList ));$skip(29); 
  val l1 = List(1, 4, 7, 10);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(36); 
  val l2 = List(2, 3, 5, 7, 12, 16);System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(512); 

  def merge[T](alist: List[T], blist: List[T])(cmp: (T, T) => Boolean): List[T] = {
    def mergeHelper(AL: List[T], BL: List[T], accList: List[T]): List[T] = (AL, BL) match {
      case (Nil, _) => accList.reverse ++ BL //this also takes care of when both lists are Nil (i.e., any)
      case (_, Nil) => accList.reverse ++ AL
      case (x :: xs, y :: ys) =>
        if (cmp(x, y)) mergeHelper(BL, xs, x :: accList)
        else mergeHelper(ys, AL, y :: accList)

    }
    mergeHelper(alist, blist, Nil)
  };System.out.println("""merge: [T](alist: List[T], blist: List[T])(cmp: (T, T) => Boolean)List[T]""");$skip(35); val res$1 = 

  merge(l1, l2)((x, y) => x <= y);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(514); 

  def mergeKeiths[T](aList: List[T], bList: List[T])(cmp: (T, T) => Boolean): List[T] = {
    def mergeHelper2(aL: List[T], bL: List[T], accList: List[T]): List[T] = (aL, bL) match {
      case (Nil, _) => accList ++ bL // could use reverse on accList
      case (_, Nil) => accList ++ aL // to save space (and time?)
      case (x :: xs, y :: ys) => {
        if (cmp(x, y)) mergeHelper2(xs, bL, accList :: x)
        else mergeHelper2(aL, ys, accList :: y)
      }
    }
    mergeHelper2(aList, bList, Nil)
  };System.out.println("""mergeKeiths: [T](aList: List[T], bList: List[T])(cmp: (T, T) => Boolean)List[T]""");$skip(40); val res$2 = 
  mergeKeiths(l1, l2)((x, y) => x <= y);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(955); 

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
     };System.out.println("""factorise: (theSeq1: Seq[Double], theSeq2: Seq[Double], factor: Double)Seq[Double]""");$skip(38); 
     
     val Seq1 = Seq (1,2,3,4,5);System.out.println("""Seq1  : Seq[Int] = """ + $show(Seq1 ));$skip(32); 
     val Seq2 = Seq (1,2,3,4,5);System.out.println("""Seq2  : Seq[Int] = """ + $show(Seq2 ));$skip(32); val res$3 = 
     
     Seq2.filter(x=> x>2);System.out.println("""res3: Seq[Int] = """ + $show(res$3));$skip(24); val res$4 = 
     
     Seq1 ++ Seq2;System.out.println("""res4: Seq[Int] = """ + $show(res$4));$skip(76); 
     
     
     val words = Array("Esha", "Manoj", "Raju", "Laju", "Pups");System.out.println("""words  : Array[String] = """ + $show(words ));$skip(45); val res$5 = 
     
     words.sortWith(_.length<_.length);System.out.println("""res5: Array[String] = """ + $show(res$5));$skip(39); val res$6 = 
     words.sortWith(_.length>_.length);System.out.println("""res6: Array[String] = """ + $show(res$6));$skip(57); val res$7 = 
     words.sortWith(_.substring(0,1) < _.substring(0,1));System.out.println("""res7: Array[String] = """ + $show(res$7));$skip(81); 
    val (first, second) = words.partition(x=> x.contains("e") | x.contains("E"));System.out.println("""first  : Array[String] = """ + $show(first ));System.out.println("""second  : Array[String] = """ + $show(second ));$skip(19); val res$8 = 
     first++second;System.out.println("""res8: Array[String] = """ + $show(res$8));$skip(83); 
     
     def squareArg(list:Int*) : Int = {
     (list.map(x => x*x)).sum
     };System.out.println("""squareArg: (list: Int*)Int""");$skip(28); val res$9 = 
     
     squareArg(1,2,4);System.out.println("""res9: Int = """ + $show(res$9));$skip(203); 
     
     def oddGT10(vector:Vector[Int]): Vector[Int] = {
     //vector.filter(x => x%2 !=0 && x>10)
     for {
     n<-vector
     if n>10
     isOdd = (n%2 !=0)
     if (isOdd)
     } yield n
     };System.out.println("""oddGT10: (vector: Vector[Int])Vector[Int]""");$skip(67); val res$10 = 
     
     oddGT10(Vector(101,21,301,401,51,6001,701,81,901,1001));System.out.println("""res10: Vector[Int] = """ + $show(res$10))}
     
     }
