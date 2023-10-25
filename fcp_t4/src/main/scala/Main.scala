import SubsecuenciaMasLarga._
@main def hello: Unit = 
  println("Hello world!")
  println(msg)
  println(bye)
  subindices(0, 3)

  println(incremental( Seq(3,3)))
  println(subSecuenciasInc(Seq(20, 30, 10, 40, 15, 16, 17)))

def msg = "I was compiled by Scala 3. :)"
