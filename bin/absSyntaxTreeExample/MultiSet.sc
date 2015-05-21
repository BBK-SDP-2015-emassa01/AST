package absSyntaxTreeExample

object MultiSet {
  println("Welcome to the Scala worksheet")

  type MultiSet = Int => Int

  def emptyMultiSet: MultiSet = { y => 0 }

  def singleton(x: Int): MultiSet = { y => if (y == x) 1 else 0 }
  def fakeMSet(z: Int): Int = { z + 1 }

  def union(a: MultiSet, b: MultiSet): MultiSet =
    { y => fakeMset(y) + b(y)
    }

}