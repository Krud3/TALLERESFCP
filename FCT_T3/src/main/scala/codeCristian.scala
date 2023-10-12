
    def definirManiobra(initialState:Tren, wantedState:Tren): Maniobra = {

        def moveHelper(state: Estado, wantedState: Tren, movs: List[Movimiento]): List[Movimiento] = {
            wantedState match {
                
                case Nil => movs
                case x::xs if (!state._1.isEmpty && x == state._1.head ) => {
                    moveHelper(state, xs, movs)
                }
                case x::xs if(state._1.isEmpty || (!state._1.isEmpty && x != state._1.head )) =>{
                    state match {

                        case (sk, Nil, Nil) => {

                            val mov = Uno(tamI(xs)+1)
                            moveHelper(aplicarMovimiento(state, mov), x::xs, movs :+ mov)
                        }

                        case (sk, s1, Nil) if(s1.head == x) => {
                            val mov = Uno(-1)
                            moveHelper(aplicarMovimiento(state, mov), xs, movs :+ mov)

                        }

                        case (sk, s1, Nil) if(s1.head != x) => {
                            val moves = Uno(-1)::Dos(1)::Nil
                            moveHelper(applyMovesToState(state,moves), x::xs, movs ++ moves)
                        }
                        
                        case (sk, Nil, s2) if(s2.head == x) => {
                            val mov = Dos(-1)
                            println("soy yo")
                            moveHelper(aplicarMovimiento(state, mov), xs, movs :+ mov)
                        }
                        case (sk, Nil, s2)  if(s2.head != x) => {
                            val moves = Dos(-1)::Uno(1)::Nil
                            moveHelper(applyMovesToState(state,moves), x::xs, movs ++ moves)
                        }
                        case (sk, s1, s2)  => {
                            val moves = Dos(-tamI(s2))::Uno(tamI(s2))::Nil
                            moveHelper(applyMovesToState(state,moves), x::xs, movs ++ moves)
                        }
                    }
                    
                }
                case _ => movs

            }
        }

        moveHelper((initialState, List(), List()), wantedState, List())
    }