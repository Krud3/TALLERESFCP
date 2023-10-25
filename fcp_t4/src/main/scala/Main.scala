import SubsecuenciaMasLarga._
@main def hello: Unit = 
  println("Hello world!")
  println(msg)
  println(bye)
  subindices(0, 3)

  println(incremental( Seq(1, 2, 3, 9, 16, 32, 89, 123, 10009, 4576565)))

def msg = "I was compiled by Scala 3. :)"
