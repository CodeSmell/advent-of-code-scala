package year2017.day_02

import advent.util.ReadFile
import advent.util.AdventUtil

object CheckSum extends ReadFile {
  def main(args: Array[String]): Unit = {
    // get the input data
    val inputData = readClassPathFileToArray("input.txt")
    val checksum = calculateCheckSumPart1(inputData)
    println(s"the checksum: ${checksum}")
  }

  def calculateCheckSumPart1(inputData: Array[String]): Int = {
    inputData.map(rowString => {convertRowToList(rowString)})
      .map(rowArray => {differenceMinAndMaxInRow(rowArray)}) // array of each rows checksum
      .reduceLeft((a:Int, b:Int) => a + b) // sum of all rows 
  }

  def differenceMinAndMaxInRow(rowArray: Array[Int]): Int = {
    rowArray.max - rowArray.min
  }
  
  /**
   * converts row to numbers 
   * and removes any non numeric
   */
  def convertRowToList(row: String): Array[Int] = {
    row.split("\\s+")
      .map(strNum => {AdventUtil.stringToNumber(strNum)})
      .flatten
  }

}