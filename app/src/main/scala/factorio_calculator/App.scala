package factorio_calculator

import scala.io.StdIn.readLine

object App {
  def main(args: Array[String]): Unit = {
    println("Enter name of product")
    val productNameRaw = readLine()
    println("Enter volume of product desired per minute")
    val targetRateRaw = readLine().toIntOption
    val output = appInputParse(productNameRaw, targetRateRaw) match {
      case Right((productName, targetRate)) => runCalculator(productName, targetRate)
      case Left(error) => error
    }
    println("Printing output:")
    println(output)
  }

  def appInputParse(productNameRaw: String, targetRateRaw: Option[Int]): Either[String, (String, Int)] = {
    targetRateRaw match {
      case Some(rate) => Right((productNameRaw, rate))
      case None => Left("Input failed, ending script")
    }
  }

  def runCalculator(productName: String, targetRate: Int): String = {
    productName ++ targetRate.toString
  }

}
