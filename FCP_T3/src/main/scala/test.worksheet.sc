import mypackage2._ 
hello
bye

val e1 = (List('a', 'b', 'c','d'), List(), List()) 
val e2 = aplicarMovimiento(e1, Uno(2)) //Esperado: (List(a, b), List(c,d), List())
val e3 = aplicarMovimiento(e2, Dos(3))//Esperado: (List(), List(c,d), List(a,b))
val e4 = aplicarMovimiento(e3, Dos(-1))//Esperado: (List(a), List(c,d), List(b))
val e5 = aplicarMovimiento(e4, Uno(-2))//Esperado: (List(a, c, d),List(),List(b))

val e6 = (List('a', 'b', 'c','d'), List(), List()) 
val e7 = aplicarMovimiento(e6, Uno(2)) //Esperado: (List('a', 'b'), List('c','d'), List())
val e8 = aplicarMovimiento(e7, Dos(1)) //Esperado: (List('a'), List('c','d'), List('b'))
val e9 = aplicarMovimiento(e8, Uno(-1)) //Esperado: (List('a','c'), List('d'), List('b'))
val e10 = aplicarMovimiento(e9, Dos(-1)) //Esperado: (List('a','c', 'b'), List('d'), List())
val e11 = aplicarMovimiento(e10, Uno(1)) //Esperado: (List('a','c'), List('b','d'), List())
val e12 = aplicarMovimiento(e11, Dos(2)) //Esperado: (List(), List('b','d'), List('a','c'))


val e = (List('a', 'b'), List('c'), List('d'))
aplicarMovimientos(e, List(Uno(1), Dos(1), Uno(-2))) //Esperado: List((List(a),List(b, c),List(d)), (List(),List(b, c),List(a, d)), (List(b, c),List(),List(a, d)))


val e13 = (List('a', 'b', 'c'), List('d'), List('e', 'f')) 

aplicarMovimientos(e13, List(Uno(2), Dos(1))) //Esperado:List((List(a),List(b, c, d),List(e, f)), (List(),List(b, c, d),List(a, e, f)))
aplicarMovimientos(e13, List(Uno(-1), Dos(2), Uno(1))) //Esperado: List((List(a, b, c, d),List(),List(e, f)), 
//(List(a, b),List(),List(c, d, e, f)), (List(a),List(b),List(c, d, e, f)))
aplicarMovimientos(e13, List(Dos(1), Uno(-1), Dos(-1))) //Esperado:List((List(a, b),List(d),List(c, e, f)), (List(a, b, d),List(),List(c, e, f)),
// (List(a, b, d, c),List(),List(e, f)))
val e14 = (List('x', 'y'), List('z', 'a', 'b'), List('c')) //Esperado: List((List(a, b),List(d),List(c, e, f)), (List(a, b, d),List(),List(c, e, f)),
// (List(a, b, d, c),List(),List(e, f)))
aplicarMovimientos(e14, List(Dos(2), Uno(1))) //Esperado: (List(x, y),List(z, a, b),List(c))
aplicarMovimientos(e14, List(Uno(-1), Dos(-2), Uno(2))) //Esperado: List((List(x, y, z),List(a, b),List(c)), (List(x, y, z, c),List(a, b),List()), 
//(List(x, y),List(z, c, a, b),List()))



definirManiobra(List('a', 'b','c','d'), List('c','b', 'd' ,'a')) //Esperado: List(Uno(5), Uno(-4), Dos(4), Uno(-1), Dos(-3), Dos(-1), Uno(4), 
//Uno(-3), Dos(3), Uno(-1), Dos(-2), Dos(-1), Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1), Dos(-1), Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('a', 'b', 'c'), List('c', 'b', 'a')) //Esperado: List(Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('w', 'x', 'y', 'z', 'a'), List('a', 'z', 'y', 'x', 'w')) //Esperado: List(Uno(5), Uno(-4), Dos(4), Uno(-1), Dos(-3), 
//Dos(-1), Uno(4), Uno(-3), Dos(3), Uno(-1), Dos(-2), Dos(-1), Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1), 
//Dos(-1), Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('m', 'n'), List('n', 'm')) //Esperado: List(Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('g', 'h', 'i', 'j', 'k', 'l'), List('l', 'k', 'j', 'i', 'h', 'g')) //Esperado: List(Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1),
// Dos(-1), Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('t', 'u', 'v'), List('v', 'u', 't')) //Esperado: List(Uno(6), Uno(-5), Dos(5), Uno(-1), Dos(-4), Dos(-1), Uno(5), Uno(-4), 
//Dos(4), Uno(-1), Dos(-3), Dos(-1), Uno(4), Uno(-3), Dos(3), Uno(-1), Dos(-2), Dos(-1), 
//Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1), Dos(-1), Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('1', '2', '3', '4', '5', '6'), List('6', '5', '4', '3', '2', '1')) //Esperado: List(Uno(7), Uno(-6), Dos(6), Uno(-1), Dos(-5),
// Dos(-1), Uno(6), Uno(-5), Dos(5), Uno(-1), Dos(-4), Dos(-1), Uno(5), Uno(-4), Dos(4), Uno(-1), Dos(-3), Dos(-1), Uno(4), Uno(-3), Dos(3), Uno(-1), 
//Dos(-2), Dos(-1), Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1), Dos(-1), Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('q', 'r', 's', 't', 'u', 'v', 'w'), List('w', 'v', 'u', 't', 's', 'r', 'q')) //Esperado: List(Uno(8), Uno(-7), Dos(7), Uno(-1), 
//Dos(-6), Dos(-1), Uno(7), Uno(-6), Dos(6), Uno(-1), Dos(-5), Dos(-1), Uno(6), Uno(-5), Dos(5), 
//Uno(-1), Dos(-4), Dos(-1), Uno(5), Uno(-4), Dos(4), Uno(-1), Dos(-3), Dos(-1), Uno(4), Uno(-3), Dos(3), 
//Uno(-1), Dos(-2), Dos(-1), Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1), Dos(-1), Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('k', 'l', 'm', 'n', 'o'), List('o', 'n', 'm', 'l', 'k')) //Esperado: List(Uno(5), Uno(-4), Dos(4), Uno(-1), Dos(-3), Dos(-1), 
//Uno(4), Uno(-3), Dos(3), Uno(-1), Dos(-2), Dos(-1), Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1), Dos(-1), Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('e', 'f'), List('f', 'e')) //Esperado: List(Uno(8), Uno(-7), Dos(7), Uno(-1), Dos(-6), Dos(-1), Uno(7), Uno(-6), Dos(6), Uno(-1),
// Dos(-5), Dos(-1), Uno(6), Uno(-5), Dos(5), Uno(-1), Dos(-4), Dos(-1), Uno(5), Uno(-4), Dos(4), Uno(-1), Dos(-3), Dos(-1), Uno(4), Uno(-3), Dos(3), 
//Uno(-1), Dos(-2), Dos(-1), Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1), Dos(-1), Uno(2), Uno(-1), Dos(1), Uno(-1), Dos(-1))
definirManiobra(List('i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'), List('p', 'o', 'n', 'm', 'l', 'k', 'j', 'i')) //Esperado: List(Uno(8), Uno(-7), Dos(7), 
//Uno(-1), Dos(-6), Dos(-1), Uno(7), Uno(-6), Dos(6), Uno(-1), Dos(-5), Dos(-1), Uno(6), Uno(-5), Dos(5), Uno(-1), Dos(-4), Dos(-1), Uno(5), Uno(-4),
// Dos(4), Uno(-1), Dos(-3), Dos(-1), Uno(4), Uno(-3), Dos(3), Uno(-1), Dos(-2), Dos(-1), Uno(3), Uno(-2), Dos(2), Uno(-1), Dos(-1), Dos(-1), Uno(2),
// Uno(-1), Dos(1), Uno(-1), Dos(-1))
