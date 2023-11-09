import common._
import Matrices._
import Benchmark._
import scala.math.pow
object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    println(msg)
    
    val values =Vector(
    matrizAlAzar(pow(2, 9).toInt, 2),
    matrizAlAzar(pow(2, 9).toInt, 2),
    matrizAlAzar(pow(2, 10).toInt, 2),
    matrizAlAzar(pow(2, 10).toInt, 2) )
      /*
    Vector(matrizAlAzar(pow(2, 0).toInt, 2)
    ,matrizAlAzar(pow(2, 0).toInt, 2)
    ,matrizAlAzar(pow(2, 1).toInt, 2)
    ,matrizAlAzar(pow(2, 1).toInt, 2)
    ,matrizAlAzar(pow(2, 2).toInt, 2)
    ,matrizAlAzar(pow(2, 2).toInt, 2)
    ,matrizAlAzar(pow(2, 3).toInt, 2)
    ,matrizAlAzar(pow(2, 3).toInt, 2)
    ,matrizAlAzar(pow(2, 4).toInt, 2)
    ,matrizAlAzar(pow(2, 4).toInt, 2)
    ,matrizAlAzar(pow(2, 5).toInt, 2)
    ,matrizAlAzar(pow(2, 5).toInt, 2)
    ,matrizAlAzar(pow(2, 6).toInt, 2)
    ,matrizAlAzar(pow(2, 6).toInt, 2)
    ,matrizAlAzar(pow(2, 7).toInt, 2)
    ,matrizAlAzar(pow(2, 7).toInt, 2)
    ,matrizAlAzar(pow(2, 8).toInt, 2)
    ,matrizAlAzar(pow(2, 8).toInt, 2))*/

    automaticBenchmark(compareAlgmMRPmSP,values).foreach(println)

    /*
    val m1 = matrizAlAzar(pow(2, 0).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 0).toInt, 10)
    val m1 = matrizAlAzar(pow(2, 1).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 1).toInt, 10)
    val m1 = matrizAlAzar(pow(2, 2).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 2).toInt, 10)
    val m1 = matrizAlAzar(pow(2, 3).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 3).toInt, 10)
    val m1 = matrizAlAzar(pow(2, 4).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 4).toInt, 10)
    val m1 = matrizAlAzar(pow(2, 5).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 5).toInt, 10)
    val m1 = matrizAlAzar(pow(2, 6).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 6).toInt, 10)
    val m1 = matrizAlAzar(pow(2, 7).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 7).toInt, 10)
    val m1 = matrizAlAzar(pow(2, 8).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 8).toInt, 10)*/
    //val m1 = matrizAlAzar(pow(2, 9).toInt, 10)
    //val m2 = matrizAlAzar(pow(2, 9).toInt, 10)
    /*
    val m1 = matrizAlAzar(pow(2, 10).toInt, 10)
    val m2 = matrizAlAzar(pow(2, 10).toInt, 10)


    val m1 = matrizAlAzar(pow(2, 0).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 0).toInt, 100)
    val m1 = matrizAlAzar(pow(2, 1).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 1).toInt, 100)
    val m1 = matrizAlAzar(pow(2, 2).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 2).toInt, 100)
    val m1 = matrizAlAzar(pow(2, 3).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 3).toInt, 100)
    val m1 = matrizAlAzar(pow(2, 4).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 4).toInt, 100)
    val m1 = matrizAlAzar(pow(2, 5).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 5).toInt, 100)
    val m1 = matrizAlAzar(pow(2, 6).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 6).toInt, 100)
    val m1 = matrizAlAzar(pow(2, 7).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 7).toInt, 100)
    val m1 = matrizAlAzar(pow(2, 8).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 8).toInt, 100)*/
    //val m1 = matrizAlAzar(pow(2, 9).toInt, 100)
    //val m2 = matrizAlAzar(pow(2, 9).toInt, 100)
    /*val m1 = matrizAlAzar(pow(2, 10).toInt, 100)
    val m2 = matrizAlAzar(pow(2, 10).toInt, 100)
    

    val m1 = matrizAlAzar(pow(2, 0).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 0).toInt, 20)
    val m1 = matrizAlAzar(pow(2, 1).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 1).toInt, 20)
    val m1 = matrizAlAzar(pow(2, 2).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 2).toInt, 20)
    val m1 = matrizAlAzar(pow(2, 3).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 3).toInt, 20)
    val m1 = matrizAlAzar(pow(2, 4).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 4).toInt, 20)
    val m1 = matrizAlAzar(pow(2, 5).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 5).toInt, 20)
    val m1 = matrizAlAzar(pow(2, 6).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 6).toInt, 20)
    val m1 = matrizAlAzar(pow(2, 7).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 7).toInt, 20)
    val m1 = matrizAlAzar(pow(2, 8).toInt, 20)
    val m2 = matrizAlAzar(pow(2, 8).toInt, 20)*/
    //val m1 = matrizAlAzar(pow(2, 9).toInt, 20)
    //val m2 = matrizAlAzar(pow(2, 9).toInt, 20)
    /*
    val m1 = matrizAlAzar(pow(2, 10).toInt, 20
    val m2 = matrizAlAzar(pow(2, 10).toInt, 20)*/

/*
    val m1 = matrizAlAzar(pow(2, 0).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 0).toInt, 500)
    val m1 = matrizAlAzar(pow(2, 1).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 1).toInt, 500)
    val m1 = matrizAlAzar(pow(2, 2).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 2).toInt, 500)
    val m1 = matrizAlAzar(pow(2, 3).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 3).toInt, 500)
    val m1 = matrizAlAzar(pow(2, 4).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 4).toInt, 500)
    val m1 = matrizAlAzar(pow(2, 5).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 5).toInt, 500)
    val m1 = matrizAlAzar(pow(2, 6).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 6).toInt, 500)
    val m1 = matrizAlAzar(pow(2, 7).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 7).toInt, 500)
    val m1 = matrizAlAzar(pow(2, 8).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 8).toInt, 500)*/
    //val m1 = matrizAlAzar(pow(2, 9).toInt, 500)
    //val m2 = matrizAlAzar(pow(2, 9).toInt, 500)
    /*
    val m1 = matrizAlAzar(pow(2, 10).toInt, 500)
    val m2 = matrizAlAzar(pow(2, 10),.toInt 500)
     */

    //compareAlgmMmP(m1, m2)
    /*compareAlgmMmR(m1, m2)
    compareAlgmMmRP(m1, m2)
    compareAlgmMmS(m1, m2)
    compareAlgmMmSP(m1, m2)
    compareAlgmMmMP(m1, m2)
    compareAlgmMRmMRP(m1, m2)
    compareAlgmMRmS(m1, m2)
    compareAlgmMRmSP(m1, m2)
    compareAlgmMRPmS(m1, m2)
    */
    //val result = compareAlgmMRPmSP(m1, m2)
    //println(result)
    /*
    compareAlgmSmSP(m1, m2)*/

  }

  def msg = "I was compiled by Scala 2.13. :)"

  def automaticBenchmark(a:(Matriz, Matriz)=>(Double,Double, Double), b: Vector[Vector[Vector[Int]]]): List[(Double,Double,Double)] ={
    (for {i <- 0 until b.length by 2} yield {
      a(b(i), b(i+1))
    }).toList
  }
  def compareAlgmMmP(m1: Matriz, m2: Matriz): (Double,Double,Double) = { 
      compararAlgoritmos(multMatriz, multMatrizPar)(m1, m2)
    }

    def compareAlgmMmR(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatriz, multMatrizRec)(m1, m2)
    }

    def compareAlgmMmRP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatriz, multMatrizRecPar)(m1, m2)
    }

    def compareAlgmMmS(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatriz, multStrassen)(m1, m2)
    }

    def compareAlgmMmSP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatriz, multStrassenPar)(m1, m2)
    }

    def compareAlgmMmMP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatriz, multStrassenPar)(m1, m2)
    }

    def compareAlgmMRmMRP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatrizRec, multMatrizRecPar)(m1, m2)
    }

    def compareAlgmMRmS(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatrizRec, multStrassen)(m1, m2)
    }
    
    def compareAlgmMRmSP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatrizRec, multStrassenPar)(m1, m2)
    }

    def compareAlgmMRPmS(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatrizRecPar, multStrassen)(m1, m2)
    }

    //ya
    def compareAlgmMRPmSP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multMatrizRecPar, multStrassenPar)(m1, m2)
    }
/*
    def compareAlgmSmSP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multStrassen, multStrassenPar)(m1, m2)
    }
    def compareAlgmSmSP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multStrassen, multStrassenPar)(m1, m2)
    }
    def compareAlgmSmSP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multStrassen, multStrassenPar)(m1, m2)
    }
    def compareAlgmSmSP(m1: Matriz, m2: Matriz): (Double,Double,Double) ={
      compararAlgoritmos(multStrassen, multStrassenPar)(m1, m2)
    }*/
}