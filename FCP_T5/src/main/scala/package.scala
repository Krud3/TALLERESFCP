import scala.util.Random
import common._
import scala.collection.parallel.immutable.ParVector

package object Matrices {

    def hello() = "Hello, world!"
    def bye() = "Bye, world!"
    val random = Random

    /*
     *   umbral: valor a partir del cual se paraleliza
    */
    val umbral = 4

    type Matriz = Vector[Vector[Int]]
    type MatrizD = ParVector[ParVector[Int]]

    def matrizAlAzar(long:Int, vals:Int) = {
        //Crea una matriz de enteros cuadrada de long x long,
        //con valores entre 0 y vals
        val v = Vector.fill(long, long){random.nextInt(vals)}
        v
    }

    def vectorAlAzar(long:Int, vals:Int): Vector[Int] = {
        //Crea un vector de enteros de longitud long,
        //con valores aleatorios entre 0 y vals
        val v = Vector.fill(long){random.nextInt(vals)}
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

    def multMatriz(m1: Matriz, m2: Matriz): Matriz = {

        val l = m1.length
        val m = m2.length
        val v =Vector.tabulate(l,m)((i,j)=>prodPunto(m1(i),transpuesta(m2)(j)))
        v
    }

    def multMatrizPar(m1: Matriz, m2: Matriz): Matriz = {
        val l = m1.length
        val m = m2.length
        val parRows = for (k <- 0 until l ) 
            yield {
                (k,task(Vector.tabulate(1,m)((i,j)=>prodPunto(m1(k),transpuesta(m2)(j))))) }
        val v = parRows.map({case (i,j) => (i,j.join())}).sortBy(_._1).map(_._2)
        v.reduce(_++_)
    }

    def multMatrizPar2(m1: Matriz, m2: Matriz): Matriz = {
        val l = m1.length
        val m = m2.length

        val (m1p1, m1p2) = m1.splitAt(l/2)
        val (v1, v2) = parallel(Vector.tabulate(l/2,m)((i,j)=>prodPunto(m1p1(i),transpuesta(m2)(j))),
                                Vector.tabulate(l-(l/2),m)((i,j)=>prodPunto(m1p2(i),transpuesta(m2)(j))))
        
        v1++v2  
    }

    def subMatriz(m: Matriz, i:Int, j:Int, l:Int): Matriz = {
        //Dada m, matriz cuadrada de NxN, 1 <= i,j <= N, i+n<= N, j+n <= N
        //devuelve la submatriz de nxn correspondiente a m[i..i+(n-1), j,..j+(n-1)]
        val v = Vector.tabulate(l,l)((k,r)=>m(i+k)(j+r))
        v
    }

    def sumMatriz(m1:Matriz, m2:Matriz): Matriz = {
        //recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
        //y devuelve la matriz resultante de la suma de las 2 matrices
        val l = m1.length
        val v = Vector.tabulate(l,l)((i,j)=>m1(i)(j)+m2(i)(j))
        v
    }

    def restaMatriz(m1:Matriz, m2:Matriz): Matriz = {
        //Recibe dos matrices, la martriz m1 y la martriz m2, las cuales son 
        // cuadradas, por tanto de igual dimension, potencia de 2
        //y devuelve la matriz resultante de la resta de las 2 matrices
        val l = m1.length
        val v = Vector.tabulate(l,l)((i,j)=>m1(i)(j)-m2(i)(j))
        v
    }

    def multMatrizRec(m1:Matriz, m2:Matriz): Matriz ={
        //recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
        //y devuelve la multiplicacion de las 2 matrices
        val n = m1.length
        if(n == 1) {
            Vector(Vector(m1(0)(0)*m2(0)(0)))
        }
        else {
            val l = n/2
            val (m1_11, m1_12, m1_21, m1_22) = 
                (subMatriz(m1,0,0,l),subMatriz(m1,0,l,l),subMatriz(m1,l,0,l),subMatriz(m1,l,l,l))
            val (m2_11, m2_12, m2_21, m2_22) =
                (subMatriz(m2,0,0,l),subMatriz(m2,0,l,l),subMatriz(m2,l,0,l),subMatriz(m2,l,l,l))

            val c_11 = sumMatriz(multMatrizRec(m1_11,m2_11),multMatrizRec(m1_12,m2_21))
            val c_12 = sumMatriz(multMatrizRec(m1_11,m2_12),multMatrizRec(m1_12,m2_22))
            val c_21 = sumMatriz(multMatrizRec(m1_21,m2_11),multMatrizRec(m1_22,m2_21))
            val c_22 = sumMatriz(multMatrizRec(m1_21,m2_12),multMatrizRec(m1_22,m2_22))

            Vector.tabulate(n,n)((i,j)=>
                if(i<l && j<l) c_11(i)(j)
                else if(i<l && j>=l) c_12(i)(j-l)
                else if(i>=l && j<l) c_21(i-l)(j)
                else c_22(i-l)(j-l))
        }
    }

    def multMatrizRecPar(m1:Matriz, m2:Matriz): Matriz ={
        //recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
        //y devuelve la multiplicacion de las 2 matrices, paralelizando tareas
        val n = m1.length
        
        /*if(umbral <= n){
            multMatrizRec(m1,m2)
        }*/
        if(n == 1) {
            Vector(Vector(m1(0)(0)*m2(0)(0)))
        }
        else {
            
            val l = n/2
            val (m1_11, m1_12, m1_21, m1_22) = 
                (subMatriz(m1,0,0,l),subMatriz(m1,0,l,l),subMatriz(m1,l,0,l),subMatriz(m1,l,l,l))
            val (m2_11, m2_12, m2_21, m2_22) =
                (subMatriz(m2,0,0,l),subMatriz(m2,0,l,l),subMatriz(m2,l,0,l),subMatriz(m2,l,l,l))

            val (c_11, c_12, c_21, c_22) = parallel(
                sumMatriz(multMatrizRec(m1_11,m2_11),multMatrizRec(m1_12,m2_21)),
                sumMatriz(multMatrizRec(m1_11,m2_12),multMatrizRec(m1_12,m2_22)),
                sumMatriz(multMatrizRec(m1_21,m2_11),multMatrizRec(m1_22,m2_21)),
                sumMatriz(multMatrizRec(m1_21,m2_12),multMatrizRec(m1_22,m2_22)))

            Vector.tabulate(n,n)((i,j)=>
                if(i<l && j<l) c_11(i)(j)
                else if(i<l && j>=l) c_12(i)(j-l)
                else if(i>=l && j<l) c_21(i-l)(j)
                else c_22(i-l)(j-l))
        }
    }


    def multStrassen(m1:Matriz, m2:Matriz): Matriz ={
        //recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
        //y devuelve la multiplicacion de las 2 matrices
        val n = m1.length
        
        /*if(umbral <= n){
            multMatrizRec(m1,m2)
        }*/
        if(n == 1) {
            Vector(Vector(m1(0)(0)*m2(0)(0)))
        }
        else {
            
            val l = n/2

            val (s1, s2, s3, s4, s5, s6, s7, s8, s9, s10) = (
                restaMatriz(subMatriz(m2,0,l,l), subMatriz(m2,l,l,l)),
                sumMatriz(subMatriz(m1,0,0,l), subMatriz(m1,0,l,l)),
                sumMatriz(subMatriz(m1,l,0,l), subMatriz(m1,l,l,l)),
                restaMatriz(subMatriz(m2,l,0,l), subMatriz(m2,0,0,l)),
                sumMatriz(subMatriz(m1,0,0,l), subMatriz(m1,l,l,l)),
                sumMatriz(subMatriz(m2,0,0,l), subMatriz(m2,l,l,l)),
                restaMatriz(subMatriz(m1,0,l,l), subMatriz(m1,l,l,l)),
                sumMatriz(subMatriz(m2,l,0,l), subMatriz(m2,l,l,l)),
                restaMatriz(subMatriz(m1,0,0,l), subMatriz(m1,l,0,l)),
                sumMatriz(subMatriz(m2,0,0,l), subMatriz(m2,0,l,l))
            )


            val (p1, p2, p3, p4, p5, p6, p7) = (
                multStrassen(subMatriz(m1,0,0,l), s1),
                multStrassen(s2, subMatriz(m2,l,l,l)),
                multStrassen(s3, subMatriz(m2,0,0,l)),
                multStrassen(subMatriz(m1,l,l,l), s4),
                multStrassen(s5, s6),
                multStrassen(s7, s8),
                multStrassen(s9, s10)
            )

            val (c_11, c_12, c_21, c_22) = (
                sumMatriz(restaMatriz(sumMatriz(p5,p4), p2), p6),
                sumMatriz(p1, p2),
                sumMatriz(p3, p4),
                restaMatriz(restaMatriz(sumMatriz(p5, p1),p3), p7)
            )

            Vector.tabulate(n,n)((i,j)=>
                if(i<l && j<l) c_11(i)(j)
                else if(i<l && j>=l) c_12(i)(j-l)
                else if(i>=l && j<l) c_21(i-l)(j)
                else c_22(i-l)(j-l))
        }
    }
  

    def multStrassenPar(m1:Matriz, m2:Matriz): Matriz ={
        //recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
        //y devuelve la multiplicacion de las 2 matrices
        val n = m1.length
        
        /*if(umbral <= n){
            multMatrizRec(m1,m2)
        }*/
        if(n == 1) {
            Vector(Vector(m1(0)(0)*m2(0)(0)))
        }
        else {
            
            val l = n/2
            
            val (s1, s2, s3, s4, s5, s6, s7, s8, s9, s10) = (
                restaMatriz(subMatriz(m2,0,l,l), subMatriz(m2,l,l,l)),
                sumMatriz(subMatriz(m1,0,0,l), subMatriz(m1,0,l,l)),
                sumMatriz(subMatriz(m1,l,0,l), subMatriz(m1,l,l,l)),
                restaMatriz(subMatriz(m2,l,0,l), subMatriz(m2,0,0,l)),
                sumMatriz(subMatriz(m1,0,0,l), subMatriz(m1,l,l,l)),
                sumMatriz(subMatriz(m2,0,0,l), subMatriz(m2,l,l,l)),
                restaMatriz(subMatriz(m1,0,l,l), subMatriz(m1,l,l,l)),
                sumMatriz(subMatriz(m2,l,0,l), subMatriz(m2,l,l,l)),
                restaMatriz(subMatriz(m1,0,0,l), subMatriz(m1,l,0,l)),
                sumMatriz(subMatriz(m2,0,0,l), subMatriz(m2,0,l,l))
            )

            val (p1, p2, p3, p4, p5, p6, p7) = (
                task(
                    multStrassenPar(subMatriz(m1,0,0,l), s1)
                ),
                task(
                    multStrassenPar(s2, subMatriz(m2,l,l,l))
                    ),
                task(
                    multStrassenPar(s3, subMatriz(m2,0,0,l))
                    ),
                task(
                    multStrassenPar(subMatriz(m1,l,l,l), s4)
                    ),
                task(
                    multStrassenPar(s5, s6)
                    ),
                task(
                    multStrassenPar(s7, s8)
                    ),
                task(
                    multStrassenPar(s9, s10)
                )
            )

            
            val (c_11, c_12, c_21, c_22) = (
                sumMatriz(
                    restaMatriz(sumMatriz(p5.join(), p4.join()),p2.join()), 
                    p6.join()),
                sumMatriz(
                    p1.join(), 
                    p2.join()),
                sumMatriz(
                    p3.join(), 
                    p4.join()),
                restaMatriz(
                    restaMatriz(sumMatriz(p5.join(),p1.join()), p3.join()), 
                    p7.join())                    
            )

            
            Vector.tabulate(n,n)((i,j)=>
                if(i<l && j<l) c_11(i)(j)
                else if(i<l && j>=l) c_12(i)(j-l)
                else if(i>=l && j<l) c_21(i-l)(j)
                else c_22(i-l)(j-l))
        }
    }

    def transformToParD(m: Matriz): MatrizD = {
        //Transforma una matriz en una matriz paralelizada de forma automatica
        new ParVector(m.map( v => new ParVector(v)))
    }

    def prodPuntoParD(v1: ParVector[Int], v2: ParVector[Int]): Int = {
        //Calcula el producto punto entre dos vectores que son paralelizados de forma automatica 
        //su procesamiento
        (v1 zip v2).map({case (i,j) => (i*j)}).sum
    }

    def transpuestaD(m: MatrizD): MatrizD = {
        //Calcula la transpuesta de una matriz
        val l =m.length
        (ParVector.tabulate(l,l)((r,s)=> m(s)(r)))
    }


    def multMatrizParD(m1: MatrizD, m2: MatrizD): MatrizD = {

        val l = m1.length
        val m = m2.length
        val v = ParVector.tabulate(l,m)((i,j)=>
            prodPuntoParD(m1(i),
            transpuestaD(m2)(j)))

        v
    }

}