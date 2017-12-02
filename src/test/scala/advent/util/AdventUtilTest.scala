package advent.util

import org.scalatest.FlatSpec

class AdventUtilTest extends FlatSpec {

  "An non numeric character" should "return None" in {
    assert(AdventUtil.charToNumber('x') == None)
  }

  "A numeric character 7" should "return 7" in {
    assert(AdventUtil.charToNumber('7').get == 7)
  }

  "An non numeric String" should "return None" in {
    assert(AdventUtil.stringToNumber("X") == None)
  }

  "A numeric String 7" should "return 7" in {
    assert(AdventUtil.stringToNumber("7").get == 7)
  }
}