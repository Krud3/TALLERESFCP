import Circuitos._
hello

val chip_not = crearChipUnario((x:Int) => (1-x))
chip_not(List(0,1,0,1,0,0,1,0,0))
val chip_and = crearChipBinario( (x: Int, y: Int ) => (x * y))
