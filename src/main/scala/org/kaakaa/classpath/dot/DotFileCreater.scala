package org.kaakaa.classpath.dot

import org.kaakaa.classpath.ide.entry.LibraryEntry
import scala.collection.mutable.ListBuffer
import java.io.PrintWriter
import org.kaakaa.classpath.ide.Project

/**
 * Created by kaakaa_hoe on 2014/05/31.
 */
class DotFileCreater {
}

object DotFileCreater {
  def output(projects: List[Project], toPath: String): Unit = {
    val out = new PrintWriter(toPath)
    out.print(makeDotText(projects))
    out.close()
  }
  
  def makeDotText(projects: List[Project]): String = {
    var result = List("digraph sample {")
    for (p <- projects) {
      result = result ::: p.getLineInDotFormat()
    }
    result.mkString(sys.props("line.separator")) + "}"
  }
}
