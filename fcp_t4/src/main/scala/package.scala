package object SubsecuenciaMasLarga {
    def hello = "Hello, world!"
    def bye = "Bye, world!"

    type Secuencia = Seq[Int];
    type Subsecuencia = Seq[Int];

    def subindices(i: Int, n: Int): Set[Subsecuencia] = {
        
        def subsecuenceHelper(i: Int, n: Int, accSubsecuence: Set[Subsecuencia]): Set[Subsecuencia] = {
            
            val determinedSubsequence: Set[Subsecuencia] = n match {
                case n if n == i => accSubsecuence ++ List()
                case _ => {
                            val subsequenceRange = (i until n)
                            (for {   
                                    subsequenceIndex <- subsequenceRange 
                                    subsequence = subsequenceRange.filter( _ <= subsequenceIndex)
                                } 
                             yield subsequence).toSet} ++ accSubsecuence                  
            }
            subsecuenceHelper(i + 1, n, determinedSubsequence)
        }

        subsecuenceHelper(i, n, Set())
    }
    
}