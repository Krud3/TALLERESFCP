import SubsecuenciaMasLarga._
@main def hello: Unit = 
  println("Hello world!")
  println(msg)
  println(bye)
  subindices(0, 3)

  println(incremental( Seq(3,3)))
  println(subSecuenciasInc(Seq(20, 30, 10, 40, 15, 16, 17)))

  println("Lista de valores -> " + sssimlComenzandoEn(4, Seq ( 10 , 9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 22 , 21 , 20 , 19 , 18 , 17 , 16 , 15 , 14 , 13 , 12 , 11, 30, 40 )))
  println("Las mas larrga de todas: " + subSecIncMasLargaV2(Seq( 10 , 9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 22 , 21 , 20 , 19 , 18 , 17 , 16 , 15 , 14 , 13 , 12 , 11)))

def msg = "I was compiled by Scala 3. :)"
