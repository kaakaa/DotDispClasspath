package org.kaakaa.classpath

import scala.sys.process.Process
import java.io.File

/**
 * Created by kaakaa_hoe on 2014/05/27.
 */
object SvnCommander {
  def recursiveList(url: String): List[String] = {
    var classpathFiles = List.empty[String]

    for(
      file <- list(url).split(sys.props("line.separator"))
      if ".classpath".equals(new File(file).getName())
    ) classpathFiles = file :: classpathFiles

    classpathFiles
  }

  def list(url: String): String = {
    //Seq("svn", "list", url) !!
    Process("svn list --recursive " +  url) !!
  }

  def cat(url: String): String = {
    Process("svn cat " + url) !!
  }
}
