
package absSyntaxTreeExample

abstract class MyList[T] {
  /*
    
    def filter (fn: T => Boolean) : List[T] = {
    this match {
    case y::ys => if (fn(y)) y :: ys.filter(fn) else ys.filter(fn)
    }
    }
  
  def map[B](f: T => B): List[B] = this match {
    case Nil => this
    case x :: xs => f(x) :: xs.map(f)
  }
  
   def reduce[U](fn: (U, U) => U): U = this match{
    case Nil => throw new Error
    case h::tail => tail.fold(h)(fn)
 }

  def fold[U,T](start:U)(fn: (U, T)=> U):U = this match {
    case Nil => start
    case h::tail => tail.fold(fn(start,h)(fn)
  }

*/

}

