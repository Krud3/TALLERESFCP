package object SubsecuenciaMasLarga {
    def hello = "Hello, world!"
    def bye = "Bye, world!"

    type Secuencia = Seq[Int];
    type Subsecuencia = Seq[Int];

    def subindices(i: Int, n: Int): Set[Subsecuencia] = {
        
        def subsecuenceHelper(i: Int, n: Int, accSubsequence: Set[Subsecuencia]): Set[Subsecuencia] = {
            
            val determinedSubsequence: Set[Subsecuencia] = n match {
                case m if m == i => accSubsequence
                case _ => {
                            val subsequenceRange = (i until n)
                            (for {   
                                    subsequenceIndex <- subsequenceRange 
                                    subsequence = subsequenceRange.filter( _ <= subsequenceIndex)
                                } 
                             yield {
                                for {
                                    k <- 0 until subsequence.size
                                    ki <- k until subsequence.size
                                    sq = subsequence.take(k)
                                } yield (sq ++ Seq(subsequence(ki)))
                            }).flatten.toSet } ++ accSubsequence                 
            }
            if (i < n) subsecuenceHelper(i + 1, n, determinedSubsequence) else accSubsequence ++ List()
        }
        subsecuenceHelper(i, n, Set())
    }

       def subindices2(i: Int, n: Int): Set[Subsecuencia] = {
        
        def subsecuenceHelper(i: Int, n: Int, accSubsequence: Set[Subsecuencia]): Set[Subsecuencia] = {
            
            val determinedSubsequence: Set[Subsecuencia] = n match {
                case m if m == i => accSubsequence
                case _ => {
                            val subsequenceRange = (i until n)
                            (   
                                for {   
                                    subsequenceIndex <- subsequenceRange 
                                    subsequence = subsequenceRange.filter( _ <= subsequenceIndex)
                                } 
                                yield subsequence
                            ).flatMap { subsequence =>
                                for {
                                    k <- 0 until subsequence.size
                                    ki <- k until subsequence.size
                                    sq = subsequence.take(k)
                                } yield (sq ++ Seq(subsequence(ki)))
                            }.toSet } ++ accSubsequence                
            }
            if (i < n) subsecuenceHelper(i + 1, n, determinedSubsequence) else accSubsequence ++ List()
        }
        subsecuenceHelper(i, n, Set())
    }
    
}