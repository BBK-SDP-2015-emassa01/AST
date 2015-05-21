package absSyntaxTreeExample

object sortElements {
  val list = List(("a", "b", "c"), ("d", "e"), ("f", "g", "h"), ("d", "e"),
    ("i", "j", "k", "l"), ("m", "n"), ("o"))      //> list  : List[java.io.Serializable] = List((a,b,c), (d,e), (f,g,h), (d,e), (i
                                                  //| ,j,k,l), (m,n), o)
    
  val list2 = List(3,2,3,2,4,2,1)                 //> list2  : List[Int] = List(3, 2, 3, 2, 4, 2, 1)

  def lenf(alist: List[java.io.Serializable]): List[Int] = alist match {
  case Nil => Nil
  case List():: Nil => List(1)
  case List()::List() => lenf(List())
  
  }                                               //> lenf: (alist: List[java.io.Serializable])List[Int]
  
  lenf(list)                                      //> scala.MatchError: List((a,b,c), (d,e), (f,g,h), (d,e), (i,j,k,l), (m,n), o) 
                                                  //| (of class scala.collection.immutable.$colon$colon)
                                                  //| 	at absSyntaxTreeExample.sortElements$$anonfun$main$1.lenf$1(absSyntaxTre
                                                  //| eExample.sortElements.scala:9)
                                                  //| 	at absSyntaxTreeExample.sortElements$$anonfun$main$1.apply$mcV$sp(absSyn
                                                  //| taxTreeExample.sortElements.scala:16)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at absSyntaxTreeExample.sortElements$.main(absSyntaxTreeExample.sortElem
                                                  //| ents.scala:3)
                                                  //| 	at absSyntaxTreeExample.sortElements.main(absSyntaxTreeExample.sortEleme
                                                  //| nts.scala)

}