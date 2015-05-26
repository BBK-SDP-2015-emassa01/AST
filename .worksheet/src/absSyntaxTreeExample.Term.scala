package absSyntaxTreeExample

sealed trait EvaluationList
final case class Term(n: Int) extends EvaluationList
final case class Sum(e1: EvaluationList, e2: EvaluationList) extends EvaluationList
final case class Minus(n1: EvaluationList, n2: EvaluationList) extends EvaluationList
final case class Func(str: String, args: List[EvaluationList]) extends EvaluationList

object strToList {
  // something to take in string and evaluate it. (2+(3-5-6))
  val str = "(2+(3-5-6))"
  val strList = str.toList
  val listNoBrackets = strList.filter(x=> x != '(' && x != ')')
  
  def createAThingy(list:List[Char]) : Expression
}
