package absSyntaxTreeExample

object strToList {

  sealed trait EvaluationList
  final case class Termy(n: Int) extends EvaluationList
  final case class Sumy(e1: EvaluationList, e2: EvaluationList) extends EvaluationList
  final case class Mult(e1: EvaluationList, e2: EvaluationList) extends EvaluationList

  // something to take in string and evaluate it. (+2(-356))

  def listNoBrackets(str: String) = str.toList.filter(x => x != '(' && x != ')')
                                                  //> listNoBrackets: (str: String)List[Char]

  def treeCreator(listNoBrackets: List[Char]): List[EvaluationList] = listNoBrackets match {
    case h :: t => if (h.isDigit) { List(Termy(h)) } else OpCreator(listNoBrackets)
  }                                               //> treeCreator: (listNoBrackets: List[Char])List[absSyntaxTreeExample.strToList
                                                  //| .EvaluationList]

  def OpCreator(listNoBrackets: List[Char]): List[EvaluationList] = listNoBrackets match {
    case h :: t => if (h == '+') { List(Sumy(Termy(h), Termy(t.head))) } else List(Mult(Termy(t.head), Termy(h)))
  }                                               //> OpCreator: (listNoBrackets: List[Char])List[absSyntaxTreeExample.strToList.E
                                                  //| valuationList]

  treeCreator(listNoBrackets("(+2(-356))"))       //> res0: List[absSyntaxTreeExample.strToList.EvaluationList] = List(Sumy(Termy(
                                                  //| 43),Termy(50)))
  listNoBrackets("(+2(-356))")                    //> res1: List[Char] = List(+, 2, -, 3, 5, 6)
  
  treeCreator(List('+', '2', '-', '3', '5', '6')) //> res2: List[absSyntaxTreeExample.strToList.EvaluationList] = List(Sumy(Termy(
                                                  //| 43),Termy(50)))
}