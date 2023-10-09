import Circuitos._
hello

val chip_not = crearChipUnario((x: Int) => (1 - x))
chip_not(List(0)) // Deberia imprimir [1]
chip_not(List(1)) // Deberia imprimir [0]
chip_not(List(-1))  // Deberia imprimir [2]
chip_not(List(3))  // Deberia imprimir [-2]
chip_not(List(99))  // Deberia imprimir [-98]

val chip_add = crearChipBinario((x: Int, y: Int) => (x * y))
chip_add(List(0, 1))  // Deberia imprimir [0]
chip_add(List(1, 1))  // Deberia imprimir [1]
chip_add(List(1, 0))  // Deberia imprimir [0]
chip_add(List(0,0))  // Deberia imprimir [0]
chip_add(List(-1, 1)) // Deberia imprimir [-1]
val chip_or = crearChipBinario((x: Int, y: Int) => (x + y) - (x * y ))
chip_or(List(0, 0))   // Deberia imprimir [0]
chip_or(List(0, 1))   // Deberia imprimir [1]
chip_or(List(1, 0))   // Deberia imprimir [1]
chip_or(List(1, 1))   // Deberia imprimir [1]
chip_or(List(-1, 0))  // Deberia imprimir [-1] 

val ha = half_adder
ha(List(0, 0))  // Deberia imprimir [0, 0]
ha(List(0, 1))  // Deberia imprimir [0, 1]
ha(List(1, 0))  // Deberia imprimir [0, 1]
ha(List(1, 1))  // Deberia imprimir [1, 0]

val fa = full_adder

fa(List(0, 0, 0))  // Debería imprimir [0, 0]
fa(List(0, 0, 1))  // Debería imprimir [0, 1]
fa(List(0, 1, 0))  // Debería imprimir [0, 1]
fa(List(0, 1, 1))  // Debería imprimir [1, 0]
fa(List(1, 0, 0))  // Debería imprimir [0, 1]
fa(List(1, 0, 1))  // Debería imprimir [1, 0]
fa(List(1, 1, 0))  // Debería imprimir [1, 0]
fa(List(1, 1, 1))  // Debería imprimir [1, 1]

val add1 = adder(1)

// Caso 1
add1(List(0) ++ List(0))  // Debería imprimir [0]
add1(List(1) ++ List(0))  // Debería imprimir [1]
val add2 = adder(2)
add2(List(1, 0) ++ List(0, 1))  // Debería imprimir [1, 1]

add2(List(0, 1) ++ List(1, 0))  // Debería imprimir [1, 1]
add2(List(1, 1) ++ List(1, 1))  // Debería imprimir [1, 0, 0]
val add3 = adder(3)
add3(List(1, 0, 0) ++ List(0, 1, 1))  // Debería imprimir [1, 1, 1]
add3(List(0, 1, 0) ++ List(1, 0, 1))  // Debería imprimir [1, 1, 1]
add3(List(1, 1, 1) ++ List(1, 1, 1))  // Debería imprimir [1, 1, 1, 0]
val add4 = adder(4)
add4(List(1, 0, 0, 1) ++ List(0, 1, 1, 0))  // Debería imprimir [1, 1, 1, 1]
add4(List(0, 1, 0, 1) ++ List(1, 0, 1, 0))  // Debería imprimir [1, 1, 1, 1]

