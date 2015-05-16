package absSyntaxTreeExample

object preAppends {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val a = Vector("a", "b", "c", "d")              //> a  : scala.collection.immutable.Vector[String] = Vector(a, b, c, d)

  "f" :+ a                                        //> res0: scala.collection.immutable.IndexedSeq[Any] = Vector(f, Vector(a, b, c,
                                                  //|  d))
  "f" +: a                                        //> res1: scala.collection.immutable.Vector[String] = Vector(f, a, b, c, d)

  a +: "f"                                        //> res2: scala.collection.immutable.IndexedSeq[Any] = Vector(Vector(a, b, c, d)
                                                  //| , f)

  a :+ "f"                                        //> res3: scala.collection.immutable.Vector[String] = Vector(a, b, c, d, f)

  val b = Vector("g", "h", "i", "j")              //> b  : scala.collection.immutable.Vector[String] = Vector(g, h, i, j)



  b :+ a                                          //> res4: scala.collection.immutable.Vector[java.io.Serializable] = Vector(g, h,
                                                  //|  i, j, Vector(a, b, c, d))
                                                  
  b +: a                                          //> res5: scala.collection.immutable.Vector[java.io.Serializable] = Vector(Vecto
                                                  //| r(g, h, i, j), a, b, c, d)

  a +: b                                          //> res6: scala.collection.immutable.Vector[java.io.Serializable] = Vector(Vecto
                                                  //| r(a, b, c, d), g, h, i, j)

  a :+ b                                          //> res7: scala.collection.immutable.Vector[java.io.Serializable] = Vector(a, b,
                                                  //|  c, d, Vector(g, h, i, j))
}