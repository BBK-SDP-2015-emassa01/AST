package absSyntaxTreeExample


  sealed trait Tree
  final case class Sum(l: Tree, r: Tree) extends Tree
  final case class Var(n: String) extends Tree
  final case class Const(v: Int) extends Tree
object AbsClassTree {
}
