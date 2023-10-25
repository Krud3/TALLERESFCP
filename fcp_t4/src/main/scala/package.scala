
package object SubsecuenciaMasLarga {
    def hello = "Hello, world!"
    def bye = "Bye, world!"

    type Secuencia = Seq[Int];
    type Subsecuencia = Seq[Int];


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
    
     def subsecuenciaIncrementalMasLarga(seq: Secuencia): Subsecuencia = {
       val subsequences = (for subsequence <- subSecuenciasInc(seq) if incremental(subsequence) yield subsequence).toList
       val subsequencesSizes = subsequences.map(_.size) 
       val indexOfLargestSubsequence = (subsequencesSizes.find(x => x == subsequencesSizes.max)) match { 
        case None => Nil 
        case Some(x) => x 
       }
       indexOfLargestSubsequence match {
        case Nil => List()
        case x: Int => subsequences(x)
        case _ => List()
      }
     }

    def subsecuenciaIncrementalMasLarga2(seq: Secuencia): Subsecuencia = {
       val subsequences = (for subsequence <- subSecuenciasInc(seq) if incremental(subsequence) yield subsequence).toList
       val subsequencesSizes = subsequences.map(_.size) 
       val indexOfLargestSubsequence = (subsequencesSizes.indexWhere(x => x == subsequencesSizes.max))
       indexOfLargestSubsequence match {
        case x if x < 0 => List()
        case x => subsequences(x)
      }
     }

     
}


