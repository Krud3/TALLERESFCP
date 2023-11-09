import Matrices._
import Benchmark._
hello()
bye()

matrizAlAzar(2,2)
val m1 =matrizAlAzar(8,3)
val m2 =matrizAlAzar(8,3)

multMatriz(m1,m2)
Runtime.getRuntime().availableProcessors()
multMatrizPar(m1,m2)
subMatriz(m1,2,2,2)
multMatrizRec(m1,m2)
multMatrizRecPar(m1,m2)

//compararAlgoritmos(multMatriz,multMatrizRec)(m1,m2)