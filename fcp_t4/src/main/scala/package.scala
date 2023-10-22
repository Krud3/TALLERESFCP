package object SubsecuenciaMasLarga {
    def hello = "Hello, world!"
    def bye = "Bye, world!"

    type Secuencia = Seq[Int];
    type Subsecuencia = Seq[Int];

    def subindices(i: Int, n: Int): Set[Subsecuencia] = {
        
        def subsecuenceHelper(i: Int, n: Int, accSubsecuence: Set[Subsecuencia]): Set[Subsecuencia] = 
            n match {
                case n  if n == i => accSubsecuence
                case _ => {
                    val subsecuenceRange = i until n
                    (for subsequenceIndex <- subsecuenceRange     
                            yield subsecuenceHelper(i + 1, n, accSubsecuence + subsecuenceRange.filter( _ <= subsequenceIndex))).toSet
                            
                        }
    }
}
}