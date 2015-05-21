//package absSyntaxTreeExample
//
//case class BigInt(x: Int) {
//// This class deals only with integers >= 0
//def digits: Array[Int] // stores BigInt as an array of Int
//def SIZE: Int // number of digits of huge integer
//def error: Boolean // if overflow or underflow occurred, then true else false
//def this() = this(0)
//def this(x: BigInt) = ???
//def this(arr: Array[Int]) = ???
//// Return a String representation of a BigInteger
//def outputBigInteger(): String = ???
//// Add x to this, put return new value
//def addBigIntegers(x: BigInt): BigInt = ???
//// Subtract x from this, return new value
//def subtractBigIntegers(x: BigInt): BigInt = ???
//// Multiply this by x, return new value
//def multiplyBigIntegers(x: BigInt): BigInt = ???
//// Divide this by x, return new value
//def divideBigIntegers(x: BigInt): BigInt = ???
//// return the remainder of this when divided by val (this is unchanged)
//def modulusBigIntegers(x: BigInt): BigInt = ???
//// true when this == x
//def isEqualTo(x: BigInt): Boolean = ???
//// true when this < x
//def isLessThan(x: BigInt): Boolean = ???
//
//def factor: BigInt = {
//if (this.modulusBigIntegers(BigInt(2)).isEqualTo(BigInt(0))) BigInt(2)
//    else this.addBigIntegers(BigInt(1)).factor
//}
//
//def enumerateFactors:Unit = ???
//def outputBigInt:Unit = ???
//
//
//}