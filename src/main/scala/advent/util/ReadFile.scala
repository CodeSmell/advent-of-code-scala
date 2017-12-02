package advent.util

import scala.io.Source
import scala.io.BufferedSource

trait ReadFile {

  def readClassPathFileToArray(fileName: String): Array[String] = {
    val buffSource = readFileFromClasspathIntoBufferedSource(fileName)
    try buffSource.getLines().toArray finally buffSource.close()
  }
  
  def readClassPathFileToString(fileName: String): String = {
    val buffSource = readFileFromClasspathIntoBufferedSource(fileName)
    try buffSource.mkString finally buffSource.close()
  }
  
  def readFileFromClasspathIntoBufferedSource(fileName: String): BufferedSource = {
    Source.fromInputStream(getClass.getResourceAsStream(fileName))
  }
}