package object mypackage2{
    def hello = println("Hello, world!")
    def bye = println("Bye, world!")
    /**
      * Definition of the elements that will be used to represent the state of the problem.
      */
    type Vagon = Any
    type Tren = List[Vagon]
    type Estado = (Tren, Tren, Tren)

    

    /**
      * Definition of the elements that will be used to represent the movements of the trajectory.
      */
    sealed trait Movimiento
    case class Uno(n: Int) extends Movimiento
    case class Dos(n: Int) extends Movimiento


    type Maniobra = List[Movimiento]

    def tamI(l : List[Any]): Int = {
        def tam(lst : List[Any], acc : Int): Int = {
        if (lst.isEmpty) acc
        else tam(lst.tail, acc + 1)
        }
        tam(l, 0)
    } 
    /**
      *                       --------e._3---
      *                      /
      *                     /
      * ---------e._1-------
      *                     \
      *                      \
      *                       --------e._2---
      */
    def aplicarMovimiento(state:Estado, mov:Movimiento): Estado = {
        mov match {
            case Uno(n) if(n > 0) => (state._1.dropRight(n),  state._1.takeRight(n) ::: state._2, state._3)
            case Dos(n) if(n > 0) => (state._1.dropRight(n), state._2, state._1.takeRight(n) ::: state._3)
            case Uno(n) if(n < 0) => (state._1 ::: state._2.take(-n),  state._2.drop(-n), state._3)
            case Dos(n) if(n < 0) => (state._1 ::: state._3.take(-n), state._2, state._3.drop(-n))
            case _  => (state._1, state._2, state._3)
        }
    }

    def aplicarMovimientos(state:Estado, movs:Maniobra): List[Estado] = {
        def helper(state:Estado, movs:Maniobra, acc:List[Estado]): List[Estado] = movs match {
            case Nil => acc
            case x::xs => {
                val newState = aplicarMovimiento(state, x)  
                helper(newState, xs, acc :+ newState)
            }
        }
        helper(state, movs, List())   
    }
    def applyMovesToState(state: Estado, moves:List[Movimiento]) = moves.foldLeft(state)((currentState, currentMovement) => aplicarMovimiento(currentState, currentMovement))

    def definirManiobra2(initialState:Tren,wantedState:Tren):Maniobra = {

        def moveHelper(state: Estado, wantedState: Tren, movs: List[Movimiento]): List[Movimiento] = {
            wantedState match {
                case Nil => movs
                //Evauates if the first element of the wanted state is the same as the first element of the current state and if the current state is not empty
                case x::xs if(!state._1.isEmpty && x == state._1.head) => {
                    moveHelper((state._1.tail,state._2,state._3), xs, movs :+ Uno(0))
                }
                //Evaluates if the first element of the wanted state is not the same as the first element of the current state
                case x::xs => {
                    state match{  
                        case (sk, Nil, Nil) =>{
                            val mov = Uno(tamI(state._1))
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }
                        case (_, s1, Nil) if (tamI(s1)==1) =>{
                            val mov = Dos(tamI(state._1))
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }
                        case (_, s1, Nil) if (tamI(state._1) == 1)=> {
                            val mov = Uno(1)
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }
                        case (_, s1, Nil) => {
                            val cant = (tamI(s1)-1)
                            val mov = Uno(-cant)
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }
                        case (_,s1,s2) if(tamI(s1)==1) => {
                            val mov = Uno(-1)
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }

                        case (_,s1,s2) if(tamI(s2)==1 ) => {
                            val mov = Dos(-1)
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }
                        case (_,Nil,s2) if (tamI(s2)==1) =>{
                            val mov = Uno(tamI(state._1))
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }
                        
                        case (_,Nil,s2) => {
                            val cant = (tamI(s2)-1)
                            val mov = Dos(-cant)
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }
                        case _ => movs
                    }                    
                }
                case _ => movs
            }
        }
        moveHelper((initialState, List(), List()), wantedState, List())
    }  
}