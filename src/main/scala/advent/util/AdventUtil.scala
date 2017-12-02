package advent.util

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object AdventUtil {
  /**
   * convert a numeric character to its Int value
   */
  def charToNumber(char: Char): Option[Int] = {
    stringToNumber(char.toString)
  }

  def stringToNumber(string: String): Option[Int] = {
    Try(string.toString.toInt) match {
      case Success(intValue) => Some(intValue)
      case Failure(f) => None
    }
  }
}