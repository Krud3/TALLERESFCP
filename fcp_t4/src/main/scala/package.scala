
import scala.compiletime.ops.int

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
      case _ => (for index <- 1 until seq.size yield  seq(index - 1) < seq(index)) forall( x => x)
    }

    def subSecuenciasInc(seq: Secuencia): Set[Subsecuencia] = 
       (for subsequence <- subSecuenciasDe(seq) if incremental(subsequence) yield subsequence).toSet
    
     def subsecuenciaIncrementalMasLarga2(seq: Secuencia): Subsecuencia = {
       val subsequences = (for subsequence <- subSecuenciasInc(seq) if incremental(subsequence) yield subsequence).toList
       val subsequencesSizes = subsequences.map(_.size) 
       (subsequences.find(x => x.size == subsequencesSizes.max)) match { 
        case None => List() 
        case Some(x) => x 
       }
     }

    def subsecuenciaIncrementalMasLarga(seq: Secuencia): Subsecuencia = {
       val subsequences = (for subsequence <- subSecuenciasInc(seq) if incremental(subsequence) yield subsequence).toList
       val subsequencesSizes = subsequences.map(_.size) 
       val indexOfLargestSubsequence = (subsequencesSizes.indexWhere(x => x == subsequencesSizes.max))
       indexOfLargestSubsequence match {
        case x if x < 0 => List()
        case x => subsequences(x)
      }
     }

    def sssimlComenzandoEn(i: Int, seq: Secuencia): Subsecuencia = {
      
      def sssimlHelper(r: Int, seq: Secuencia, subsequence: Subsecuencia, maxValueOfSubsequence: Int): Subsecuencia = {
        r match {
            case r if seq.size == r => subsequence
            case r => {
              val isLargestValue = seq(r) > maxValueOfSubsequence
              sssimlHelper(
              r + 1, 
              seq, 
              if (isLargestValue) subsequence ++ List(seq(r)) else subsequence, 
              if (isLargestValue) seq(r) else maxValueOfSubsequence)
            }
        }}

      val subsequences = (
        for{ k <- i until seq.size 
              j <- k  until seq.size
              subsequence = sssimlHelper(j, seq, List(seq(k)), seq(k))
      } yield {
        subsequence}).toList
      val subsequencesMaxSize = subsequences.map(_.size).max
      subsequences.find(x => x.size == subsequencesMaxSize) match {
        case None => List() 
        case Some(x) => x
      }
    }


    def sssimlComenzandoEn2(i: Int, seq: Secuencia): Subsecuencia = {

      val subsequences = (
        for{ k <- i until seq.size 
              j <- k  until seq.size
              subsequence = seq
              .drop(k)
              .foldLeft( List(seq(k)) )( (acc, el) => if(acc.last < el) acc ++ List(el) else acc )
      } yield {
        subsequence})
      println(subsequences)
      val subsequencesMaxSize = subsequences.map(_.size).max
      subsequences.find(x => x.size == subsequencesMaxSize) match {
        case None => List() 
        case Some(x) => x
      }
    }


    def subSecIncMasLargaV2(sequence: Secuencia) = 
      val si = (for i <- 0 until sequence.size yield sssimlComenzandoEn(i, sequence))
      val siSizes = for j <- 0 until si.size yield si(j).size
      (si.find(x => x.size == siSizes.max)) match {
          case None => List()
          case Some(x) => x 
      }

     
}


