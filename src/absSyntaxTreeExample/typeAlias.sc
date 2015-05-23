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
  
  type Player= (String, String, Int)
  type Squad = Seq[Player]
  type Division = Seq[Squad]
  
  val myplayer1 = ("lil", "bil", 1)               //> myplayer1  : (String, String, Int) = (lil,bil,1)
  val myplayer3 = ("lil", "bil", 1)               //> myplayer3  : (String, String, Int) = (lil,bil,1)
  
  val mySquad = Seq(myplayer1, myplayer3)         //> mySquad  : Seq[(String, String, Int)] = List((lil,bil,1), (lil,bil,1))
  val mySquad2 = Seq(myplayer1, myplayer3)        //> mySquad2  : Seq[(String, String, Int)] = List((lil,bil,1), (lil,bil,1))
  val mySquad3 = Seq(myplayer1, myplayer3)        //> mySquad3  : Seq[(String, String, Int)] = List((lil,bil,1), (lil,bil,1))
  
  val myDivision = Seq(mySquad, mySquad2, mySquad3)
                                                  //> myDivision  : Seq[Seq[(String, String, Int)]] = List(List((lil,bil,1), (lil,
                                                  //| bil,1)), List((lil,bil,1), (lil,bil,1)), List((lil,bil,1), (lil,bil,1)))
  
  def avgAge(squad: Squad):Double = {
  (squad.map(x => x._3).foldLeft(0)(_+_))/squad.length
  }                                               //> avgAge: (squad: absSyntaxTreeExample.typeAlias.Squad)Double
  
  println(avgAge(mySquad))                        //> 1.0
  
  def partitionSquad(squad:Squad): (Squad, Squad) = {
  squad partition (x=> x._3 > avgAge(squad))
  }                                               //> partitionSquad: (squad: absSyntaxTreeExample.typeAlias.Squad)(absSyntaxTreeE
                                                  //| xample.typeAlias.Squad, absSyntaxTreeExample.typeAlias.Squad)
  
  println(partitionSquad(mySquad))                //> (List(),List((lil,bil,1), (lil,bil,1)))
  
   def keepAge(division: Division, ageBoundary: Int):Division = {
    division collect {case x => x.foreach (x=> x._3 >=ageBoundary) }
    division
   }                                              //> keepAge: (division: absSyntaxTreeExample.typeAlias.Division, ageBoundary: In
                                                  //| t)absSyntaxTreeExample.typeAlias.Division
  println(keepAge(myDivision, 1))                 //> List(List((lil,bil,1), (lil,bil,1)), List((lil,bil,1), (lil,bil,1)), List((
                                                  //| lil,bil,1), (lil,bil,1)))
  
  //range 19-20, Map[Int=>Int]
  def range1920(division:Division):Map[Int,Int] = {
  var mapy= Map[Int, Int]()
 
  division.foreach(x => x.foreach(y=>
  //if it doesnt contain
  mapy = mapy + (y._3-> 1)))
  mapy
  }                                               //> range1920: (division: absSyntaxTreeExample.typeAlias.Division)Map[Int,Int]
  
  def playersRange(lo:Int, high:Int, player:Player): Player ={
  if ((player._3 > lo ) & player._3<high) List(player._3)
  player
   
  }                                               //> playersRange: (lo: Int, high: Int, player: absSyntaxTreeExample.typeAlias.P
                                                  //| layer)absSyntaxTreeExample.typeAlias.Player
  
  
  
}