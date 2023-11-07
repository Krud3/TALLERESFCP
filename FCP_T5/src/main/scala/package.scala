import scala.util.Random

package object Matrices {

    def hello() = "Hello, world!"
    def bye() = "Bye, world!"

    type Matriz = Vector[Vector[Int]]

    def matrizAlAzar(long:Int, vals:Int) = {
        //Crea una matriz de enteros cuadrada de long x long,
        //con valores entre 0 y vals
        val v = Vector.fill(long, long){Random.nextInt(vals)}
        v
    }

    def vectorAlAzar(long:Int, vals:Int): Vector[Int] = {
        //Crea un vector de enteros de longitud long,
        //con valores aleatorios entre 0 y vals
        val v = Vector.fill(long){Random.nextInt(vals)}
        v
    }

    def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
        //Calcula el producto punto entre dos vectores
        (v1 zip v2).map({case (i,j) => i*j}).sum
    }

    def transpuesta(m: Matriz): Matriz = {
        //Calcula la transpuesta de una matriz
        val l =m.length
        Vector.tabulate(l,l)((i,j)=>m(j)(i))
    }
}