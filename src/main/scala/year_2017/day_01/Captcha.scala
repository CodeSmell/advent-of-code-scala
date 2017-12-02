package year_2017.day_01

import scala.util.Success
import scala.util.Failure
import scala.util.Try
import advent.util.AdventUtil
import advent.util.ReadFile

object Captcha extends ReadFile {
  def main(args: Array[String]): Unit = {
    // get the input data
    val inputData = readClassPathFileToString("input.txt")
    val captchaSum = calculateCaptchaSumPart2(inputData)
    println(s"the captcha sum: ${captchaSum}")
  }

  /** 
   *  find the sum of all digits that match the next digit in the list. 
   *  The list is circular, so the digit after the last digit 
   *  is the first digit in the list.
   */
  def calculateCaptchaSumPart1(inputData: String): Int = {
    val cArray = inputData.toCharArray
    var prevChar = cArray(0)
    var sumIt = 0
    for (i <- 1 until cArray.length) {
      sumIt = if (prevChar == cArray(i)) sumIt + AdventUtil.charToNumber(cArray(i)).getOrElse(0) else sumIt
      prevChar = cArray(i)
    }
    if (cArray(0) == cArray(cArray.length - 1)) sumIt + AdventUtil.charToNumber(cArray(0)).getOrElse(0) else sumIt
  }
  
    /** 
   *  find the sum of all digits that match the digit halfway around the circular list
   */
  def calculateCaptchaSumPart2(inputData: String): Int = {
    val cArray = inputData.toCharArray
    val stepFactor = cArray.length/2
    var sumIt = 0
    for (i <- 0 until cArray.length) {
      val currChar = cArray(i)
      val cmpIdx = if (i < stepFactor) (i + stepFactor) else (i - stepFactor)
      val cmpChar = cArray(cmpIdx)
      sumIt = if (currChar == cmpChar) sumIt + AdventUtil.charToNumber(currChar).getOrElse(0) else sumIt
    }
    sumIt
  }

}