package absSyntaxTreeExample

object sortElements {
  val list = List(("a", "b", "c"), ("d", "e"), ("f", "g", "h"), ("d", "e"),
    ("i", "j", "k", "l"), ("m", "n"), ("o"))      //> list  : List[java.io.Serializable] = List((a,b,c), (d,e), (f,g,h), (d,e), (i
                                                  //| ,j,k,l), (m,n), o)
    
  val list2 = List(3,2,3,2,4,2,1)                 //> list2  : List[Int] = List(3, 2, 3, 2, 4, 2, 1)

  def lenf(alist: List[java.io.Serializable]): Int = alist match {
  case Nil => 0
  case a:: Nil => 1
  case a::b => 1+ lenf(b)
  
  }                                               //> lenf: (alist: List[java.io.Serializable])Int
  
  lenf(list)                                      //> res0: Int = 7

}