import mypackage._

val lista = List(1,2,3,4,5,6,7,8,9,10)
val lista2 = List(3,1,8,2,5,4,9,6,10,7)
val listaRepetida = List(2,2,3,4,6,1,1,4,9)
val listaUnElemento = List(1)
val listaVacia = List()
// Caso con lista ordenada
tamI(lista) // Esperado: 10
// Caso con lista desordenada
tamI(lista2) // Esperado: 10
// Caso con lista con elementos repetidos
tamI(listaRepetida) // Esperado: 9
// Caso con lista de un elemento
tamI(listaUnElemento) // Esperado: 1
// Caso con lista vacía
tamI(listaVacia) // Esperado: 0

val listaNegativos = List(-10, -5, -1, 0, 5, 10)
val listaImpares = List(1, 3, 5, 7, 9, 11, 13)
val listaInversa = List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
val listaSaltos = List(1, 10, 2, 9, 3, 8, 4, 7, 5, 6)
// Caso con números negativos
(menoresQue(listaNegativos, 0))  // Esperado: List(-10, -5, -1)
// Caso solo con números impares
(menoresQue(listaImpares, 10))  // Esperado: List(1, 3, 5, 7, 9)
// Caso con lista en orden inverso
(menoresQue(listaInversa, 5))  // Esperado: List(4, 3, 2, 1)
// Caso con lista que "salta" en orden
(menoresQue(listaSaltos, 6))  // Esperado: List(1, 2, 3, 4, 5)
// Caso con lista vacía
(menoresQue(listaVacia, 5))  // Esperado: List()

val listaFibonacci = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
val listaMultiplos = List(5, 10, 20, 15, 45, 25, 30, 35, 40, 50)
val listaSoloCeros = List(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
val listaGrandes = List( 800, 900,300,100, 200, 400, 500, 1000,600, 700)
val listaMixta = List(1, 100, 2, 99, 3, 98, 4, 97, 5, 96)
// Caso con secuencia de Fibonacci
k_elem(listaFibonacci, 5)  // Esperado: 3
// Caso con múltiplos de 5
k_elem(listaMultiplos, 3)  // Esperado: 15
// Caso con solo ceros
k_elem(listaSoloCeros, 7)  // Esperado: 0
// Caso con números grandes
k_elem(listaGrandes, 9)  // Esperado: 900
// Caso con lista mixta
k_elem(listaMixta, 2)  // Esperado: 2

val listaPrimos = List(23, 3, 2, 19, 17, 13, 11, 7, 5, 29)
val listaDescendente = List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
val listaNegativoss = List(-5, -3, -1, -4, -2, 0, -6, -7, -8, -9)
val listaSaltoss = List(1000, 10, 100, 1, 10000, 0, 100000, -10, -100, -1000)
val listaRepetidos = List(1, 3, 2, 3, 1, 2, 3, 1, 2, 3)
// Caso con números primos
ordenar(listaPrimos)  // Esperado: List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
// Caso con lista en orden descendente
ordenar(listaDescendente)  // Esperado: List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
// Caso con números negativos
ordenar(listaNegativoss)  // Esperado: List(-9, -8, -7, -6, -5, -4, -3, -2, -1, 0)
// Caso con saltos en magnitudes
ordenar(listaSaltoss)  // Esperado: List(-1000, -100, -10, 0, 1, 10, 100, 1000, 10000, 100000)
// Caso con números repetidos
ordenar(listaRepetidos)  // Esperado: List(1, 1, 1, 2, 2, 2, 3, 3, 3, 3)