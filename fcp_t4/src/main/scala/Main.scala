import SubsecuenciaMasLarga._
@main def hello: Unit = 
  println("Hello world!")
  println(msg)
  println(bye)
  subindices(0, 3)

  //println(incremental( Seq(3,3)))
  //println(subSecuenciasInc(Seq(20, 30, 10, 40, 15, 16, 17)))

  println(subSecIncMasLargaV2(Seq()))
  println(subSecIncMasLargaV2(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) ) 
  println(subSecIncMasLargaV2(Seq(5, 6, 7, 1, 2, 3, 4, 8, 9, 10))  )
  println(subSecIncMasLargaV2(Seq(10, 20, 5, 15, 25, 35, 45))  )
  println(subSecIncMasLargaV2(Seq(2, 4, 6, 8, 1, 3, 5, 7, 9))  )
  println(subSecIncMasLargaV2(Seq(5, 1, 2, 3, 4, 6, 7, 8, 9, 10))) 



def msg = "I was compiled by Scala 3. :)"
