package absSyntaxTreeExample

object AbstactTree {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

sealed trait Tree
final case class Sum(l: Tree, r: Tree) extends Tree
final case class Var(n: String) extends Tree
final case class Const(v: Int) extends Tree
 
 type Environment = String => Int

object  absTree extends App{
  
  
  
  def eval(t: Tree, env: Environment): Int = t match {
    case Sum(l, r) => eval(l, env) + eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
   }
  }

def derive(t: Tree, v: String): Tree = t match {
case Sum(l, r) => Sum(derive(l, v), derive(r, v))
case Var(n) if (v == n) => Const(1)
case _ => Const(0)
}                                                 //> derive: (t: absSyntaxTreeExample.AbstactTree.Tree, v: String)absSyntaxTreeEx
                                                  //| ample.AbstactTree.Tree


val exp: Tree = Sum(Sum(Var("x"),Var("x")),Sum(Const(7),Var("y")))
                                                  //> exp  : absSyntaxTreeExample.AbstactTree.Tree = Sum(Sum(Var(x),Var(x)),Sum(Co
                                                  //| nst(7),Var(y)))
val env: Environment = { case "x" => 5 case "y" => 7 }
                                                  //> env  : absSyntaxTreeExample.AbstactTree.Environment = <function1>
println("Expression: " + exp)                     //> Expression: Sum(Sum(Var(x),Var(x)),Sum(Const(7),Var(y)))
println("Evaluation with x=5, y=7: " + absTree.eval(exp, env))
                                                  //> Evaluation with x=5, y=7: 24
println("Derivative relative to x:\n " + derive(exp, "x"))
                                                  //> Derivative relative to x:
                                                  //|  Sum(Sum(Const(1),Const(1)),Sum(Const(0),Const(0)))
println("Derivative relative to y:\n " + derive(exp, "y"))
                                                  //> Derivative relative to y:
                                                  //|  Sum(Sum(Const(0),Const(0)),Sum(Const(0),Const(1)))

}