package io.tokenanalyst.udfs

import org.scalatest.{FlatSpec, Matchers}

class SquareSpec extends FlatSpec with Matchers {
  "square" should "calculate squares correctly" in {
    val udf = new Square()
    udf.square(2.0) should equal(4.0)
    udf.square(2) should equal(4)
  }
}

class SqrtSpec extends FlatSpec with Matchers {
  "sqrt" should "calculate square roots correctly" in {
    val udf = new Sqrt()
    udf.sqrt(4.0) should equal(2.0)
    udf.sqrt(4) should equal(2)
  }
}