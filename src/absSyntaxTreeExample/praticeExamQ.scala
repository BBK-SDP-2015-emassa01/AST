package absSyntaxTreeExample

//import scala.math._
//import scala.io._

object praticeExamQ extends App {

  def estimateB(a: Double, bmin: Double, bmax: Double, err: Double): Double = {
    if ((a + ((bmin + bmax) / 2) / a) - a / ((bmin + bmax) / 2).abs < err) (bmin + bmax) / 2
    else {
      if ((a + ((bmin + bmax) / 2) / a) > a / ((bmin + bmax) / 2)) estimateB(a - 0.1, bmin + 0.1, bmax + 0.1, err)
      else estimateB(a + 0.1, bmin - 0.1, bmax - 0.1, err)
    }
  }

  def createFractal(n: Int): List[String] = {
    def helper(n: Int, acc: List[String]): List[String] = {
      
      if (n==0) {
        acc
      } else {

        print(drawPattern1(n).mkString)
        println(" ")
        println(drawPattern2(n).mkString)
        createFractal(n-1)

      }
    }
    helper(n, List())
  }

  def drawPattern1(n: Int): Array[String] = {
    Array.fill(n)("  |")
  }

  def drawPattern2(n: Int): Array[String] = {
    Array.fill(n)(" /|") 
  }

  def drawSpace: Array[String] = {
    Array(" ", " ")
    Array(" ", " ")
  }
 

  println(createFractal(4))
//  print(drawPattern1(2) mkString)
//  println(" ")
//  print(drawPattern2(2) mkString)
  
  
  def add3(x:Int)= (i:Int) => x+i


}