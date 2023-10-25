
package object SubsecuenciaMasLarga {
    def hello = "Hello, world!"
    def bye = "Bye, world!"

    type Secuencia = Seq[Int];
    type Subsecuencia = Seq[Int];

 def tamI(l : List[Int]): Int = {
    //Función auxiliar que recibe una lista y un acumulador
    //para que no sea necesario inicializar el acumulador en cada llamada
    def tam(lst : List[Int], acc : Int): Int = {
      if (lst.isEmpty) acc
      else tam(lst.tail, acc + 1)
    }
    //Llamada a la función auxiliar con el acumulador inicializado a 0
    tam(l, 0)
  } 

  //1.2
  //Crea una lista con los elementos de la lista l que son menores
  //que value
  def menoresQue(l : List[Int], value : Int): List[Int] = {

    //Caso base: lista vacía retorna lista vacía
    if (l.isEmpty) l

    //Caso recursivo: si la cabeza de la lista es menor que value
    //se agrega a la lista resultante, para luego agregar el resultado
    //de la llamada recursiva con la cola de la lista y el proceso
    //se repite
    else if (l.head < value) l.head :: menoresQue(l.tail, value)

    //Si la cabeza de la lista no es menor que value, se llama
    //recursivamente con la cola de la lista
    else menoresQue(l.tail, value)
  }

  //Crea una lista con los elementos de la lista l que son mayores
  // o iguales que value
  def noMenoresQue(l: List[Int], value : Int): List[Int] = {

    //Caso base: lista vacía retorna lista vacía
    if (l.isEmpty) l

    //Caso recursivo: si la cabeza de la lista es mayor que value
    //se agrega a la lista resultante, para luego agregar el resultado
    //de la llamada recursiva con la cola de la lista y el proceso
    //se repite
    else if (l.head >= value) l.head :: noMenoresQue(l.tail, value)

    //Si la cabeza de la lista no es mayor que value, se llama
    //recursivamente con la cola de la lista
    else noMenoresQue(l.tail, value)
  }

  //Ordena una lista de enteros de manera recursiva
  def ordenar(l: List[Int]): List[Int]={
    //Caso base: lista vacía o de un elemento, retorna la lista
    if(l.isEmpty || tamI(l)==1) l
    //Caso recursivo: se llama recursivamente con la lista de los elementos
    //menores que la cabeza de la lista, la cabeza de la lista y la lista de
    //los elementos mayores que la cabeza de la lista
    //Para concatenarse
    else ordenar(menoresQue(l.tail, l.head)) ++ List(l.head) ++ ordenar(noMenoresQue(l.tail, l.head))
  }  


    /**
      * Return all the increasing subsequences of a sequence of size n
      *
      * @param i Starting index of the sequence
      * @param n End index of the sequence
      * @return A set containing all the increasing subsequences of the sequence between i and n
      */
    def subindices(i: Int, n: Int): Set[Seq[Int]] = {
        val elements = (i until n).toSet
        (for {
            k <- 0 to elements.size
            combination <- elements.subsets(k)
        } yield combination.toSeq.sorted ).toSet 
    }

    /**
      * Return the sequence corresponding to the values of the inds sequence
      *
      * @param s Sequence to extract the subsequence from
      * @param inds Index values to stratct from s
      * @return A seq containing the values of s at the positions specified by inds values
      */
    def subSecuenciaAsoc(s:Secuencia, inds:Seq[Int]): Subsecuencia = 
        (for i <- 0 to inds.size-1 yield s(inds(i))).toList
    
    /**
      * Returns all possible subsequences of the provided sequence 's'.
      *
      * This function generates all combinations of indices for the sequence 's'
      * and then extracts the associated subsequences using the `subSecuenciaAsoc` method.
      *
      * @param s The original sequence from which to generate the subsequences.
      * @return A set containing all possible subsequences of 's'.
      */
    def subSecuenciasDe(s:Secuencia): Set[Subsecuencia] ={
        val combinationIndex = subindices(0, s.size) 
        for index <- combinationIndex yield subSecuenciaAsoc(s, index)
    }


    def incremental(seq: Subsecuencia): Boolean = seq match {
      case Nil => true
      case _ => (for index <- 1 to (seq.size - 1) yield  seq(index - 1) < seq(index)) forall( x => x)
    }

    def subSecuenciasInc(seq: Secuencia): Set[Subsecuencia] = 
       (for subsequence <- subSecuenciasDe(seq) if incremental(subsequence) yield subsequence).toSet
    
     def subsecuenciaIncrementalMasLarga(seq: Secuencia): Subsecuencia = 
       (for subsequence <- subSecuenciasInc(seq) if incremental(subsequence) yield subsequence).toList.max
}