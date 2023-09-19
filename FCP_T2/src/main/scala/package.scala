package object mypackage {

     //The DSL(Domain Specific Language) Chip type declaration 
     type Chip = List [Int] => List [Int]
      def hello = println("Hello, world!")

     

def crearChipUnario ( f: Int => Int ) : Chip =

}

def chip_not = crearchipunario( (x:Int) => (x - 1))

  

def crearChipBinario ( f: ( Int, Int ) => Int ) : Chip = {

  // On every item in the currentList argument(in the head), apply the function f, and then call
  // the operate function iteratively on the tail of the current list more the the result of the partial list
  def operation(f, currentList, result) {
            operation(f(currentList.head)::result, result)
  }
  // Return the function which do the binary oparation on every item of the list
  (operands: List[Int]) => operator(f, operands, List()) 
}


def chip_add = crearChipBinario( (x: Int, y: Int ) => (x * y))
def chip_or = crearChipBinario( (x: Int, y: Int ) => (x + y) - (x * y ))



def crearChipUnario ( f: Int => Int ) : Chip = {

}

def halfadder : Chip = {

}

def fulladder : Chip = {

}


def adder ( n : Int ) : Chip = {}



}
