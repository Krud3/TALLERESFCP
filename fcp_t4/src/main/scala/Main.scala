import SubsecuenciaMasLarga._
@main def hello: Unit = 
  println("Hello world!")
  println(msg)
  println(bye)
  subindices(0, 3)

  //println(incremental( Seq(3,3)))
  //println(subSecuenciasInc(Seq(20, 30, 10, 40, 15, 16, 17)))

  val s12 = Seq(20, 30, 10, 15, 16, 17)
  println(subsecuenciaIncrementalMasLarga(s12) ) 
  val s13 = Seq(20, 30, 10)
  println(subsecuenciaIncrementalMasLarga(s13) ) 
  val s14 = Seq(1, 2, 3, 4, 5)
  println(subsecuenciaIncrementalMasLarga(s14))
  val s15 = Seq(5, 10, 15, 14, 13, 12)
  println(subsecuenciaIncrementalMasLarga(s15))
  val s16 = Seq(2, 4, 8, 7, 6, 5)
  println(subsecuenciaIncrementalMasLarga(s16))
  val s17 = Seq(0, 1, 1, 2, 3, 5, 4)
  println(subsecuenciaIncrementalMasLarga(s17))
    val s18 = Seq(10, 20, 30, 25, 35, 45)
  println(subsecuenciaIncrementalMasLarga(s18) )//List


def msg = "I was compiled by Scala 3. :)"
