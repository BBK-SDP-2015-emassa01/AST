package absSyntaxTreeExample

sealed trait EvaluationList
final case class Termy(n: Int) extends EvaluationList
final case class Sumy(e1: EvaluationList, e2: EvaluationList) extends EvaluationList
final case class Mult(e1: EvaluationList, e2: EvaluationList) extends EvaluationList

object strToList {
  // something to take in string and evaluate it. (+2(-356))

  def listNoBrackets(str:String) = str.toList.filter(x => x != '(' && x != ')')
  
  def treeCreator(listNoBrackets: List[Char]): List[EvaluationList] = listNoBrackets match {
    case h :: t => if (h.isDigit) { List(Termy(h)) } else OpCreator(listNoBrackets)
  }
  
  def OpCreator(listNoBrackets: List[Char]): List[EvaluationList] =   listNoBrackets match {
  case h::t => if (h == '+') { List(Sumy(Termy(h), Termy(t.head)))} else List(Mult(Termy(t.head), Termy(h)))
  }
  
  treeCreator(listNoBrackets("(+2(-356))"))

}
