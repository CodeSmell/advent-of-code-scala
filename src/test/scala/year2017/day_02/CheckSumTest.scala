package year2017.day_02

import org.scalatest.FlatSpec

class CheckSumTest extends FlatSpec {

  "The input 5 1 9 5" should "return captcha 8" in {
    val testRow = Array(5, 1, 9, 5)
    assert(CheckSum.differenceMinAndMaxForRow(testRow) == 8)
  }

  "The input 7 5 3" should "return captcha 4" in {
    val testRow = Array(7, 5, 3)
    assert(CheckSum.differenceMinAndMaxForRow(testRow) == 4)
  }

  "The input 2 4 6 8" should "return captcha 6" in {
    val testRow = Array(2, 4, 6, 8)
    assert(CheckSum.differenceMinAndMaxForRow(testRow) == 6)
  }

  "The input 5 9 2 8" should "return captcha 4" in {
    val testRow = Array(5, 9, 2, 8)
    assert(CheckSum.quotientForRow(testRow) == 4)
  }

  "The input 9 4 7 3" should "return captcha 3" in {
    val testRow = Array(9, 4, 7, 3)
    assert(CheckSum.quotientForRow(testRow) == 3)
  }

  "The input 3 8 6 5" should "return captcha 2" in {
    val testRow = Array(3, 8, 6, 5)
    assert(CheckSum.quotientForRow(testRow) == 2)
  }

  "The first pass for input 5 2 9 8" should "is undefined" in {
    val testRow = Array(5, 2, 9, 8)
    assert(!CheckSum.findQuotientForGivenValueInRow(0, testRow).isDefined)
  }

  "The 2nd pass for input 5 2 9 8" should "yield 4" in {
    val testRow = Array(5, 2, 9, 8)
    assert(CheckSum.findQuotientForGivenValueInRow(1, testRow).get == 4)
  }

  "The checksum for part 1" should "return correct answer" in {
    val inputData = CheckSum.readClassPathFileToArray("input.txt")
    assert(CheckSum.calculateCheckSumPart1(inputData) == 32121)
  }

  "The checksum for part 2" should "return correct answer" in {
    val inputData = CheckSum.readClassPathFileToArray("input.txt")
    assert(CheckSum.calculateCheckSumPart2(inputData) == 197)
  }

}