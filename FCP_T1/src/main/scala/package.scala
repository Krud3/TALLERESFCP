package object mypackage {
  def hello = println("Hello, world!")

  //1.1
  //Calcula el tamaño de una lista de enteros con un proceso iterativo
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
    if (l.isEmpty) Nil

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
    if (l.isEmpty) Nil

    //Caso recursivo: si la cabeza de la lista es mayor que value
    //se agrega a la lista resultante, para luego agregar el resultado
    //de la llamada recursiva con la cola de la lista y el proceso
    //se repite
    else if (l.head >= value) l.head :: noMenoresQue(l.tail, value)

    //Si la cabeza de la lista no es mayor que value, se llama
    //recursivamente con la cola de la lista
    else noMenoresQue(l.tail, value)
  }

  //1.3
  //Calcula el k-ésimo elemento de una lista de enteros
  def k_elem(l : List[Int], k : Int) : Int = {
    //Caso base: lista vacía, k <= 0 o k > tamaño de la lista
    //retorna excepción
    if(l.isEmpty || k <= 0 || k > tamI(l)) 
        throw new IllegalArgumentException("Entrada inválida")
    //Caso base: si el tamaño de la lista de elementos menores que
    //la cabeza de la lista es igual a k - 1, retorna la cabeza de la lista
    if(tamI(menoresQue(l, l.head)) == k - 1) l.head
    //Caso recursivo: si el tamaño de la lista de elementos menores que
    //la cabeza de la lista es mayor o igual a k, se llama recursivamente
    else if(tamI(menoresQue(l, l.head)) >= k) k_elem(menoresQue(l, l.head), k)
    //De lo contrario, se llama recursivamente con la lista de los elementos
    //mayores que la cabeza de la lista y k - el tamaño de la lista de los
    //elementos menores que la cabeza de la lista - 1
    else k_elem(noMenoresQue(l, l.head), k - tamI(menoresQue(l, l.head)) - 1)
  }

  //1.4
  //Ordena una lista de enteros de manera iterativa
  def ordenar(l: List[Int]): List[Int]={
    //Caso base: lista vacía o de un elemento, retorna la lista
    if(l.isEmpty || tamI(l)==1) l
    //Caso recursivo: se llama recursivamente con la lista de los elementos
    //menores que la cabeza de la lista, la cabeza de la lista y la lista de
    //los elementos mayores que la cabeza de la lista
    //Para concatenarse
    else ordenar(menoresQue(l.tail, l.head)) ++ List(l.head) ++ ordenar(noMenoresQue(l.tail, l.head))
  }  
  
}