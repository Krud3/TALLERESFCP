import mypackage2._ 
hello
bye

val e1 = (List('a', 'b', 'c','d'), List(), List())
val e2 = aplicarMovimiento(e1, Uno(2))
val e3 = aplicarMovimiento(e2, Dos(3))
val e4 = aplicarMovimiento(e3, Dos(-1))
val e5 = aplicarMovimiento(e4, Uno(-2))

val e = (List('a', 'b'), List('c'), List('d'))
aplicarMovimientos(e, List(Uno(1), Dos(1), Uno(-2)))
definirManiobra2(List('a', 'b','c','d'), List('c','b', 'd' ,'a'))

val trenMelo = (List('a', 'b','c','d'), List(), List())
aplicarMovimientos(trenMelo, List(Uno(4), Uno(-1), Dos(1), Dos(-1), Uno(1),Uno(-1)))