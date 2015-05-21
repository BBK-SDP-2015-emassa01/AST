package absSyntaxTreeExample

object MultiSet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); 
  println("Welcome to the Scala worksheet")

  type MultiSet = Int => Int;$skip(74); 

  def emptyMultiSet: MultiSet = { y => 0 };System.out.println("""emptyMultiSet: => absSyntaxTreeExample.MultiSet.MultiSet""");$skip(67); 

  def singleton(x: Int): MultiSet = { y => if (y == x) 1 else 0 };System.out.println("""singleton: (x: Int)absSyntaxTreeExample.MultiSet.MultiSet""");$skip(40); 
  def fakeMSet(z: Int): Int = { z + 1 };System.out.println("""fakeMSet: (z: Int)Int""");$skip(87); 

  def union(a: MultiSet, b: MultiSet): MultiSet =
    { y => fakeMset(y) + b(y)
    };System.out.println("""union: (a: absSyntaxTreeExample.MultiSet.MultiSet, b: absSyntaxTreeExample.MultiSet.MultiSet)absSyntaxTreeExample.MultiSet.MultiSet""")}

}
