package org.kaakaa.classpath.dot

import org.kaakaa.classpath.ide.entry.LibraryEntry
import scala.collection.mutable.ListBuffer
import java.io.PrintWriter
import org.kaakaa.classpath.ide.Project
import scala.collection.mutable.HashSet

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
    var result = List("[")
    var prefix = ""
    for (p <- projects) {
      result = result ::: List(prefix.concat(p.getLineInDotFormat()))
      prefix = ","
    }

    var pathList: List[String] = List.empty
    for (p <- projects) {
      pathList = pathList ::: p.getClassPathNames()
    }
    for (path <- pathList.distinct) {
      result = result ::: List(prefix.concat("""{"type": "view", "name": %s, "depends": []}""".format(path)))
    }

    result = result ::: List("]")
    result.mkString(sys.props("line.separator"))
  }
}
