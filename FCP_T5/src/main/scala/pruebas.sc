import Matrices._
import Benchmark._
import common._
hello()
bye()

matrizAlAzar(2,2)
val m1 =matrizAlAzar(4,3)
val m2 =matrizAlAzar(4,3)

multMatriz(m1,m2)
//Runtime.getRuntime().availableProcessors()
multMatrizPar(m1,m2)
subMatriz(m1,2,2,2)
sumMatriz(m1,m2)
multMatrizRec(m1,m2)
multMatrizRecPar(m1,m2)
restaMatriz(m1,m2)
multStrassen(m1,m2)


multStrassenPar(m1,m2)
   multStrassen(m1,m2)
   multMatrizRec(m1,m2)
//Estan comentados los siguientes porque pueden tardan mucho
//automaticBenchmark(compareAlgmMRPmSP,values)
//compararAlgoritmos(multMatriz,multMatrizRec)(m1,m2)