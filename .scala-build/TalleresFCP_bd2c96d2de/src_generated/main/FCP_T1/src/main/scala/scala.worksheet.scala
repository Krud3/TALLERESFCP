
package FCP_T1.src.main.scala



final class scala$u002Eworksheet$_ {
def args = scala$u002Eworksheet_sc.args$
def scriptPath = """FCP_T1/src/main/scala/scala.worksheet.sc"""
/*<script>*/
import mypackage._

hello

tamI(List(12, 3, 1, 8, 4, 7))
ordenar(List(12, 3, 1, 8, 4, 7, 5, 2, 9, 6))
/*</script>*/ /*<generated>*/
/*</generated>*/
}

object scala$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new scala$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export scala$u002Eworksheet_sc.script as scala$u002Eworksheet

