package absSyntaxTreeExample

object typeAlias {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

/*  trait PlayerTrait {
    type Player
    val surname: String
    val firstname: String
    val age: Int
  }
*/

  class Class {
  
  type Player= (String, String, Int)
  type Squad = Seq[Player]
  type Division = Seq[Squad]
  
  def avgAge(squad: Squad):Double = {
  (squad.map(x => x._3).foldLeft(0)(_+_))/squad.length
  }
  
  def partitionSquad(squad:Squad): (Squad, Squad) = {
  squad partition (x=> x._3 > avgAge(squad))
  }
  
  //range 19-20, Map[Int=>Int]
  def range1920(division:Division):Map[Int,Int] = {
  var mapy= Map[Int, Int]()
 
  division.foreach(x => x.foreach(y=>
  //if it doesnt contain
  mapy = mapy + (y._3-> 1)))
  mapy
  }
  
  def playersRange(lo:Int, high:Int, player:Player): Player ={
  if ((player._3 > lo ) & player._3<high) List(player._3)
  player
   
  }
  
  }
  
}