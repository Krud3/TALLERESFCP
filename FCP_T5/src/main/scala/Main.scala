import common._
import Matrices._
object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    println(msg)
    val m1 =matrizAlAzar(4,2)
    val m2 =matrizAlAzar(4,2)
    /*val startTime = System.nanoTime()
    multMatriz(m1,m2)
    val endTime = System.nanoTime()*/
    /*val starTime2 = System.nanoTime()
    multMatriz(m1,m2)
    val endTime2 = System.nanoTime()*/

    /*val starTime1 = System.nanoTime()
    multMatrizRec(m1,m2)
    val endTime1 = System.nanoTime()*/

    //val starTime3 = System.nanoTime()
    //multMatrizRecPar(m1,m2)
    println(multStrassen(m1,m2))
    //val endTime3 = System.nanoTime()
    /*val starTime3 = System.nanoTime()
    multMatrizPar2(m1,m2)
    val endTime3 = System.nanoTime()*/
    /*println("Tiempo de ejecución secuencial multMatriz:       " + (endTime2 - starTime2) + " ns")*/
    /*println("Tiempo de ejecución secuencial multMatrizRec:    " + (endTime1 - starTime1) + " ns")*/
    //println("Tiempo de ejecución secuencial multMatrizRecPar: " + (endTime3 - starTime3) + " ns")
  }

  def msg = "I was compiled by Scala 2.13. :)"
}