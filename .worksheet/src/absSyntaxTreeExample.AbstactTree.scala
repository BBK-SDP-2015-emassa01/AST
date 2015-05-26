package absSyntaxTreeExample

object AbstactTree {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet")

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
  };$skip(555); 

def derive(t: Tree, v: String): Tree = t match {
case Sum(l, r) => Sum(derive(l, v), derive(r, v))
case Var(n) if (v == n) => Const(1)
case _ => Const(0)
};System.out.println("""derive: (t: absSyntaxTreeExample.AbstactTree.Tree, v: String)absSyntaxTreeExample.AbstactTree.Tree""");$skip(69); 


val exp: Tree = Sum(Sum(Var("x"),Var("x")),Sum(Const(7),Var("y")));System.out.println("""exp  : absSyntaxTreeExample.AbstactTree.Tree = """ + $show(exp ));$skip(55); 
val env: Environment = { case "x" => 5 case "y" => 7 };System.out.println("""env  : absSyntaxTreeExample.AbstactTree.Environment = """ + $show(env ));$skip(30); 
println("Expression: " + exp);$skip(63); 
println("Evaluation with x=5, y=7: " + absTree.eval(exp, env));$skip(59); 
println("Derivative relative to x:\n " + derive(exp, "x"));$skip(59); 
println("Derivative relative to y:\n " + derive(exp, "y"))}

}
