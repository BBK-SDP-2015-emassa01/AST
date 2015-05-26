package absSyntaxTreeExample

object strToList {

  sealed trait EvaluationList
  final case class Termy(n: Int) extends EvaluationList
  final case class Sumy(e1: EvaluationList, e2: EvaluationList) extends EvaluationList
  final case class Mult(e1: EvaluationList, e2: EvaluationList) extends EvaluationList;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(453); 

  // something to take in string and evaluate it. (+2(-356))

  def listNoBrackets(str: String) = str.toList.filter(x => x != '(' && x != ')');System.out.println("""listNoBrackets: (str: String)List[Char]""");$skip(182); 

  def treeCreator(listNoBrackets: List[Char]): List[EvaluationList] = listNoBrackets match {
    case h :: t => if (h.isDigit) { List(Termy(h)) } else OpCreator(listNoBrackets)
  };System.out.println("""treeCreator: (listNoBrackets: List[Char])List[absSyntaxTreeExample.strToList.EvaluationList]""");$skip(210); 

  def OpCreator(listNoBrackets: List[Char]): List[EvaluationList] = listNoBrackets match {
    case h :: t => if (h == '+') { List(Sumy(Termy(h), Termy(t.head))) } else List(Mult(Termy(t.head), Termy(h)))
  };System.out.println("""OpCreator: (listNoBrackets: List[Char])List[absSyntaxTreeExample.strToList.EvaluationList]""");$skip(45); val res$0 = 

  treeCreator(listNoBrackets("(+2(-356))"));System.out.println("""res0: List[absSyntaxTreeExample.strToList.EvaluationList] = """ + $show(res$0));$skip(31); val res$1 = 
  listNoBrackets("(+2(-356))");System.out.println("""res1: List[Char] = """ + $show(res$1));$skip(53); val res$2 = 
  
  treeCreator(List('+', '2', '-', '3', '5', '6'));System.out.println("""res2: List[absSyntaxTreeExample.strToList.EvaluationList] = """ + $show(res$2))}
}
