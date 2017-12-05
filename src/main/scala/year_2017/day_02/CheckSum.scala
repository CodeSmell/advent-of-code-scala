package year_2017.day_02

import advent.util.ReadFile
import advent.util.AdventUtil

object CheckSum extends ReadFile {
  def main(args: Array[String]): Unit = {
    // get the input data
    val inputData = readClassPathFileToArray("input.txt")
    val checksum = calculateCheckSumPart2(inputData)
    println(s"the checksum: ${checksum}")
  }

  def calculateCheckSumPart1(inputData: Array[String]): Int = {
    inputData.map(rowString => { convertRowToList(rowString) })
      .map(rowArray => { differenceMinAndMaxForRow(rowArray) }) // array of each rows checksum
      .reduceLeft((a: Int, b: Int) => a + b) // sum of all rows
  }

  def calculateCheckSumPart2(inputData: Array[String]): Int = {
    inputData.map(rowString => { convertRowToList(rowString) })
      .map(rowArray => { quotientForRow(rowArray) }) // array of each rows checksum
      .reduceLeft((a: Int, b: Int) => a + b) // sum of all rows
  }

  /**
   * determine the difference between the largest value and the smallest value
   */
  def differenceMinAndMaxForRow(rowArray: Array[Int]): Int = {
    rowArray.max - rowArray.min
  }

  /**
   * find the only two numbers in each row where one evenly divides the other
   * and return the result of dividing them
   */
  def quotientForRow(rowArray: Array[Int]): Int = {
    val arrayResults = for (i <- 0 until rowArray.length) yield {
      findQuotientForGivenValueInRow(i, rowArray)
    }
    
    // only one value should be > 0
    arrayResults
      .map(optInt => {
        optInt.getOrElse(0)
       })
      .reduceLeft((a: Int, b: Int) => a + b)
  }

  /**
   * find the two numbers (in a row) that divide and
   * return the result of dividing them or None
   */
  def findQuotientForGivenValueInRow(startingIndex: Int, intArray: Array[Int]): Option[Int] = {
    val testValue = intArray(startingIndex)
    val nextValueIndex = startingIndex + 1
    val arrayResults = for (i <- nextValueIndex until intArray.length) yield {
      val cmpValue = intArray(i)
      if (testValue % cmpValue == 0) {
        testValue / cmpValue
      } else if (cmpValue % testValue == 0) {
        cmpValue / testValue
      } else {
        0
      }
    }
    // only one value should be > 0
    // but they might all be 0
    arrayResults.filter(anInt => anInt > 0).headOption
  }

  /**
   * converts row to numbers
   * and removes any non numeric
   */
  def convertRowToList(row: String): Array[Int] = {
    row.split("\\s+")
      .map(strNum => { AdventUtil.stringToNumber(strNum) })
      .flatten
  }

}