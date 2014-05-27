package org.kaakaa.classpath

/**
 * Created by kaakaa_hoe on 2014/05/27.
 */
object SvnCommander {
  def recursiveList(url: String): List[String] = {
    var classpathFiles = List.empty[String]
    list(url) split sys.props("line.separator") foreach{
      e => (e, e.endsWith("/")) match {
        case (_, true) => recursiveList(toDeepUrl(url, e))
        case (_, false) if e.endsWith(".classpath") => classpathFiles = toDeepUrl(url, e) +: classpathFiles
        case _ =>
      }
    }
    classpathFiles
  }

  def list(url: String): String = {
    Seq("svn", "list", url) !!
  }

  def toDeepUrl(url: String, name: String): String = {
    if (url.endsWith("/")) {
      url + name
    } else {
      url + "/" + name
    }
  }

  def cat(url: String): String = {
    Seq("svn", "cat", url) !!
  }
}
