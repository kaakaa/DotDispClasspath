package org.kaakaa.classpath.dot

import org.kaakaa.classpath.Project
import org.kaakaa.classpath.entry.LibraryEntry
import scala.collection.mutable.ListBuffer

/**
 * Created by kaakaa_hoe on 2014/05/31.
 */
class DotFileCreater {
}

object DotFileCreater {
  def output(list: List[Project]): String = {
    var result = List("digraph sample {")
    for (p <- list) {
      result = result ::: p.getLineInDotFormat()
    }
    result.mkString(sys.props("line.separator")) + "}"
  }
}
