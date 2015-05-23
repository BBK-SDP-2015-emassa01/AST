package absSyntaxTreeExample

object typeAlias {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  println("Welcome to the Scala worksheet")

/*  trait PlayerTrait {
    type Player
    val surname: String
    val firstname: String
    val age: Int
  }
*/
  
  type Player= (String, String, Int)
  type Squad = Seq[Player]
  type Division = Seq[Squad];$skip(250); 
  
  val myplayer1 = ("lil", "bil", 1);System.out.println("""myplayer1  : (String, String, Int) = """ + $show(myplayer1 ));$skip(36); 
  val myplayer3 = ("lil", "bil", 1);System.out.println("""myplayer3  : (String, String, Int) = """ + $show(myplayer3 ));$skip(45); 
  
  val mySquad = Seq(myplayer1, myplayer3);System.out.println("""mySquad  : Seq[(String, String, Int)] = """ + $show(mySquad ));$skip(43); 
  val mySquad2 = Seq(myplayer1, myplayer3);System.out.println("""mySquad2  : Seq[(String, String, Int)] = """ + $show(mySquad2 ));$skip(43); 
  val mySquad3 = Seq(myplayer1, myplayer3);System.out.println("""mySquad3  : Seq[(String, String, Int)] = """ + $show(mySquad3 ));$skip(55); 
  
  val myDivision = Seq(mySquad, mySquad2, mySquad3);System.out.println("""myDivision  : Seq[Seq[(String, String, Int)]] = """ + $show(myDivision ));$skip(100); 
  
  def avgAge(squad: Squad):Double = {
  (squad.map(x => x._3).foldLeft(0)(_+_))/squad.length
  };System.out.println("""avgAge: (squad: absSyntaxTreeExample.typeAlias.Squad)Double""");$skip(30); 
  
  println(avgAge(mySquad));$skip(106); 
  
  def partitionSquad(squad:Squad): (Squad, Squad) = {
  squad partition (x=> x._3 > avgAge(squad))
  };System.out.println("""partitionSquad: (squad: absSyntaxTreeExample.typeAlias.Squad)(absSyntaxTreeExample.typeAlias.Squad, absSyntaxTreeExample.typeAlias.Squad)""");$skip(38); 
  
  println(partitionSquad(mySquad));$skip(156); 
  
   def keepAge(division: Division, ageBoundary: Int):Division = {
    division collect {case x => x.foreach (x=> x._3 >=ageBoundary) }
    division
   };System.out.println("""keepAge: (division: absSyntaxTreeExample.typeAlias.Division, ageBoundary: Int)absSyntaxTreeExample.typeAlias.Division""");$skip(34); 
  println(keepAge(myDivision, 1));$skip(219); 
  
  //range 19-20, Map[Int=>Int]
  def range1920(division:Division):Map[Int,Int] = {
  var mapy= Map[Int, Int]()
 
  division.foreach(x => x.foreach(y=>
  //if it doesnt contain
  mapy = mapy + (y._3-> 1)))
  mapy
  };System.out.println("""range1920: (division: absSyntaxTreeExample.typeAlias.Division)Map[Int,Int]""");$skip(141); 
  
  def playersRange(lo:Int, high:Int, player:Player): Player ={
  if ((player._3 > lo ) & player._3<high) List(player._3)
  player
   
  };System.out.println("""playersRange: (lo: Int, high: Int, player: absSyntaxTreeExample.typeAlias.Player)absSyntaxTreeExample.typeAlias.Player""")}
  
  
  
}
