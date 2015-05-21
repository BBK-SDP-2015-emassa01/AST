package absSyntaxTreeExample

trait Generator[+T] {
  self =>
  // an alias for this.
  def generate: T
  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    def generate = f(self.generate).generate
  }
  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate = f(self.generate)
  }
  implicit def integers: Generator[Int] = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  }
  implicit def choose(lo: Int, hi: Int): Generator[Int] = new Generator[Int] {
    def generate = scala.util.Random.nextInt(hi - lo) + lo
  }

  def positives: Generator[Int] = integers.map { x => if (x < 0) -x else x }

  def oneOf[T](ls: List[T]): Generator[T] = {
    choose(0, ls.length - 1).map { x => ls(x) }
  }
  case class Pie(kind: String)
  val pieKinds = List("Stewed Eels", "Jellied Eels", "only beef", "no mash or liquor")
  var pieNumbers = String => Int = { x =>
    x match {
      case "Stewed Eels" => 1
      case "Jellied Eels" => 2
      case "only beef" => 1
      case "no mash or liquor" => 3
    }
  }
  val pieGen: Generator[Pie] = {
    oneOf(pieKinds map { s => Pie(s) })
  }
  
  val pieChannel: Observable[Pie] = ???
  val piesByKind: Observable[(String, Observable[Pie])] =
  pieChannel.groupBy(pieKinds).map {x=> (x, Pie(x)}

}