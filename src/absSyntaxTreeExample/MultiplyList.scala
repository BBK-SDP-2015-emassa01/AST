
package absSyntaxTreeExample

object MultiplyList extends App {

  def multiply(list: List[Double], value: Double): List[Double] = {
    list match {
      case Nil => Nil
      case x :: xs => x * value :: multiply(xs, value)
    }
  }
  println("Multiply")
  println(multiply(List(2, 3, 4), 2))

  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case x :: xs => x + sum(xs)
  }
  println("Sum")
  println(sum(List(1,2,3,4,5)))
  
  
  
  def product(list: List[Int]): Int = list match {
    case Nil => 1
    case x :: xs => x * product(xs)
  }
  println("Product")
  println(product(List(1,2,3,4,5)))
  
  println("Fold")
  println(List(1,2,3,4,5).fold(1)((x,y)=> x*y))
 
  println("Reduce")
  println(List(1,2,3,4,5).reduce((x,y)=> x-y))
  
}