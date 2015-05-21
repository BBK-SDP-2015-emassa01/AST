package absSyntaxTreeExample

object sortElements {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(172); 
  val list = List(("a", "b", "c"), ("d", "e"), ("f", "g", "h"), ("d", "e"),
    ("i", "j", "k", "l"), ("m", "n"), ("o"));System.out.println("""list  : List[java.io.Serializable] = """ + $show(list ));$skip(39); 
    
  val list2 = List(3,2,3,2,4,2,1);System.out.println("""list2  : List[Int] = """ + $show(list2 ));$skip(137); 

  def lenf(alist: List[java.io.Serializable]): Int = alist match {
  case Nil => 0
  case a:: Nil => 1
  case a::b => 1+ lenf(b)
  
  };System.out.println("""lenf: (alist: List[java.io.Serializable])Int""");$skip(16); val res$0 = 
  
  lenf(list);System.out.println("""res0: Int = """ + $show(res$0))}

}
