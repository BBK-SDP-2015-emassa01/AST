package absSyntaxTreeExample

//EVAL TREE
sealed trait EvaluationTree
final case class Term(i: Int) extends EvaluationTree
final case class Function(str: String, args: Seq[EvaluationTree]) extends EvaluationTree
final case class Sum(e1: EvaluationTree, e2: EvaluationTree) extends EvaluationTree
final case class Prod(e1: EvaluationTree, e2: EvaluationTree) extends EvaluationTree



object MyEvaluationTree extends App {

  def mkString(args: Seq[EvaluationTree], str: String): String =
    args match {
      case Nil => " "
      case s :: Nil => printATree(s)
      case h :: tail => printATree(h) + str + mkString(tail, str)
    }

  def printATree(et: EvaluationTree): String = et match {
    case Term(i) => i.toString
    case Function(str, args) => "(" + mkString(args, str) + ")"
  }

  def eval(expr: EvaluationTree): Int = expr match {
    case Term(n) => n
    case Sum(ex1, ex2) => eval(ex1) + eval(ex2)
    case Prod(ex1, ex2) => eval(ex1) * eval(ex2)
  }

  println("Printing the tree...")
  println(printATree(Function("+", Seq(Term(2), Function("*", Seq(Term(3), Term(5), Term(6)))))))
  println("Evaluating the tree...")
  println(eval(Sum(Term(2), Prod(Term(3), Term(5)))))

  //FLATTEN
  val thingToPrint = List(List(1, 2), List(3, 4))
  def flatten(seq: Seq[Seq[Int]]): Seq[Int] = seq match {
    case Nil => Nil
    case h :: tail => h ++ flatten(tail)
  }
  println(thingToPrint)
  println(flatten(thingToPrint))
  
  //FLATTEN EVAL TREE
    def flattenTree(seq: Seq[Seq[EvaluationTree]]): Seq[EvaluationTree] = seq match {
    case Nil => Nil
    case h :: tail => h ++ flattenTree(tail)
  }

  
  // something to take in string and evaluate it. (2+(3-5-6))
  
  val str = "(2+(3-5-6))"
  
  val strList = str.toList
  

}