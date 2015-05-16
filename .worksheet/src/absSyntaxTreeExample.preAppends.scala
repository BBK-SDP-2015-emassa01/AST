package absSyntaxTreeExample

object preAppends {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
  println("Welcome to the Scala worksheet");$skip(38); 

  val a = Vector("a", "b", "c", "d");System.out.println("""a  : scala.collection.immutable.Vector[String] = """ + $show(a ));$skip(12); val res$0 = 

  "f" :+ a;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Any] = """ + $show(res$0));$skip(11); val res$1 = 
  "f" +: a;System.out.println("""res1: scala.collection.immutable.Vector[String] = """ + $show(res$1));$skip(12); val res$2 = 

  a +: "f";System.out.println("""res2: scala.collection.immutable.IndexedSeq[Any] = """ + $show(res$2));$skip(12); val res$3 = 

  a :+ "f";System.out.println("""res3: scala.collection.immutable.Vector[String] = """ + $show(res$3));$skip(38); 

  val b = Vector("g", "h", "i", "j");System.out.println("""b  : scala.collection.immutable.Vector[String] = """ + $show(b ));$skip(12); val res$4 = 



  b :+ a;System.out.println("""res4: scala.collection.immutable.Vector[java.io.Serializable] = """ + $show(res$4));$skip(60); val res$5 = 
                                                  
  b +: a;System.out.println("""res5: scala.collection.immutable.Vector[java.io.Serializable] = """ + $show(res$5));$skip(10); val res$6 = 

  a +: b;System.out.println("""res6: scala.collection.immutable.Vector[java.io.Serializable] = """ + $show(res$6));$skip(10); val res$7 = 

  a :+ b;System.out.println("""res7: scala.collection.immutable.Vector[java.io.Serializable] = """ + $show(res$7))}
}
