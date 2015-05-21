package absSyntaxTreeExample

object MultiSet extends App {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(103); 
  println("Welcome to the Scala worksheet")

  type MultiSet = Int => Int;$skip(74); 

  def emptyMultiSet: MultiSet = { y => 0 };System.out.println("""emptyMultiSet: => absSyntaxTreeExample.MultiSet.MultiSet""");$skip(67); 

  def singleton(x: Int): MultiSet = { y => if (y == x) 1 else 0 };System.out.println("""singleton: (x: Int)absSyntaxTreeExample.MultiSet.MultiSet""");$skip(132); 

  //def fakeMSet(z: Int): MultiSet = {y=>  z + 1 }

  def union(a: MultiSet, b: MultiSet): MultiSet =
    { y => a(y) + b(y)
    };System.out.println("""union: (a: absSyntaxTreeExample.MultiSet.MultiSet, b: absSyntaxTreeExample.MultiSet.MultiSet)absSyntaxTreeExample.MultiSet.MultiSet""");$skip(57); 

  def intersect(a: MultiSet, b: MultiSet): MultiSet=???;System.out.println("""intersect: (a: absSyntaxTreeExample.MultiSet.MultiSet, b: absSyntaxTreeExample.MultiSet.MultiSet)<error>""")}

}
