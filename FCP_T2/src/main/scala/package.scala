package object Circuitos {


  /** The DSL(Domain Specific Language) Chip type declaration
  */
  type Chip = List [Int] => List [Int]

  def hello = println("Hello, world!")
   
  /**
    * Create a Chip type (@see Chip) for a unary operation in every elememts of passed in arg list.  
    * @param  f (Int => Int) A higher-order function to apply in every element of the list from arg parameter of returned function.
    * @return Chip  A data type representing a function from Int list to Int list
    */
  def crearChipUnario( f: Int => Int ) : Chip = (arg: List[Int]) => {

    // Apply the f function on the head of current list and call recursively
    // the crearChipUnarioHelper with function f, a accumulated list with new transformed value as its head,
    // and the current list tail, until the empty list condition is reached.
    def crearChipUnarioHelper(f: Int => Int, transformedList: List[Int],  currentList: List[Int]): List[Int] =
      if (currentList.isEmpty) transformedList
      else crearChipUnarioHelper(f, f(currentList.head)::transformedList, currentList.tail)

    // The initial state of the iteration
    crearChipUnarioHelper(f, List(), arg)
  }



  /**
    * Create a Chip type (@see Chip) for a unary operation in every elememts of passed in arg list.  
    * @param  f ((Int, Int) => Int) A higher-order function to apply in every element of the list from arg parameter of returned function.
    * @return Chip  A data type representing a function from Int list to Int list
    */
  def crearChipBinario ( f: (Int, Int) => Int ) : Chip =  (arg: List[Int]) => {

    // On every item in the currentList argument(in the head), apply the function f, and then call
    // the operate function iteratively on the tail of the current list more the the result of the partial list
    def crearChipBinarioHelper(f: (Int, Int) => Int, transformedList: List[Int], currentList: List[Int]): List[Int] =
      if( currentList.isEmpty || currentList.tail.isEmpty) transformedList
      else crearChipBinarioHelper(f, f(currentList.head, currentList.tail.head)::transformedList, currentList.tail.tail)
    
    // The initial State of the recursion
    crearChipBinarioHelper(f, List(), arg)
  }

/**
    * Create a Chip that invert the input value
    * @param  f (Int => Int) A higher-order function that complements its argument(It supposed the arg be 0 or 1 value)
    * @return Chip  A data type representing a function from Int list to Int list
    */
  def chip_not = crearChipUnario((x:Int) => (1 - x))

 /**
    * Create a Chip type (@see Chip) for AND binary operation - logical conjunction
    * @param  f ((Int, Int) => Int) A higher-order function to apply in every consecutive values of the arguments list.
    * @return Chip  A data type representing a function from Int list to Int list
    */
  def chip_add = crearChipBinario( (x: Int, y: Int ) => (x * y))

/**
    * Create a Chip type (@see Chip) for OR binary operation - logical disjunction
    * @param  f ((Int, Int) => Int) A higher-order function to apply in every consecutive values of the arguments list.
    * @return Chip  A data type representing a function from Int list to Int list
    */
  def chip_or = crearChipBinario( (x: Int, y: Int ) => (x + y) - (x * y ))


  /**
    * Implementation of the logical operation tah define a halfadder
    * @return Chip  A data type representing a function from Int list to Int list
    */
  def half_adder : Chip = ( operands: List[Int]) => {
    val add = chip_add(operands)  // Do the first AND operation between A and B inputs - figure "Semisumador" reference
    val or = chip_or(operands)      // Do the first OR operation between A and B inputs - figure "Semisumador" reference
    val not_add = chip_not(add)    // Negate the result of the previous OR operation
    val s = chip_add(or ++ not_add) // Do the AND operation between previous result of OR operation and the negated value of the previous AND operation
    val c = add
    c ++ s // Return the halfadder result and the carry value
  }

  def full_adder : Chip = (operands: List[Int]) => {
      val halfAdder_1 = half_adder(operands.head::operands.tail.head::Nil) // Pass in the A and the B values
      val halfAdder_2 = half_adder(halfAdder_1.tail.head::operands.tail.tail.head::Nil) // Pass in the previous halfadder result and the C value
      val C_out = chip_or(halfAdder_1.head::halfAdder_2.head::Nil).head // Select the carriage of every previous half_adder
      C_out::halfAdder_2.tail.head::Nil // Return the list of the result of the sum and its carry value
  }



  /**
    * Do boolean addition on operands of n digits
    * @param n The digit number of the every operand
    * @return Tuple(List[Int], List[Int])  Two list of the length n
  */
  
    def adder ( n : Int ) : Chip = (operands: List[Int]) => {

    /**
    * Return a tuple of two list splited in n elements 
        * @param n Number to split the original list
        * @param lowerList A list that accumlates the first n elements
        * @param upperList A list that ends with last n elements
        * @return Tuple(List[Int], List[Int])  Two list of the length n
    */
    def splitList(n: Int, counter: Int, lowerList: List[Int], upperList: List[Int]): (List[Int], List[Int]) =
      if( (n + 1)  == counter ) (lowerList, upperList)
      else splitList(n , counter + 1, upperList.head::lowerList, upperList.tail)

    val (l1, l2) = splitList(n, 1, List(), operands)  // Call the splitList function and save its result in a tuple of Int List
     /**
    * Calculate recursively the sum of the two number of n digits 
        * @param accumulatedList The parcial accumulated result list; The tail of this list is the caariage of the operation in every step
        * @param firstList A list that represents the first number
        * @param lastList A list that represents the second number
        * @return List[Int] The number resulted of the sum operation
    */
    def adderHelper( accumulatedList: List[Int],  firstList:List[Int],  secondList: List[Int] ): List[Int] = {
      if(firstList.isEmpty || secondList.isEmpty) accumulatedList     // Check if the some list is empty to end the recursion proccess
      else {
        val fullAddResult = full_adder(firstList.head::secondList.head::accumulatedList.head::Nil) // Pass in to the fulladder: the head of the first list, the head of second list and the head of the accumulated list which has the carriage of previous full_adder operation
        return adderHelper( fullAddResult ++ accumulatedList.tail, firstList.tail, secondList.tail )// Const he partial result list with previous adder result, and pass in the rest(tail) of both list.
      }
    }
    val initial_sum = half_adder(l1.head::l2.head::Nil) // Determine the first digiit sum without carriage input
    val result = adderHelper( initial_sum.tail.head::initial_sum.head::Nil, l1.tail, l2.tail) // Arrange the accumulated list so the carriage is in the head
    result.reverse
  }

  

}