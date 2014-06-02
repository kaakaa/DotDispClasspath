package org.kaakaa.classpath

import org.kaakaa.classpath.dot.DotFileCreater
import java.io.File

/**
 * Created by kaakaa_hoe on 2014/06/01.
 */
object Main {

  def main(args: Array[String]): Unit = {
    try {
      val (rootUrl, toPath) = getArgs(args)

      val projects = ProjectModelCreator(rootUrl)
      DotFileCreater.output(projects, toPath)

    } catch {
      case e: IllegalArgumentException =>
        println(e.getMessage())
    }

  }

  def getArgs(args: Array[String]): (String, String) = {
    args.length match {
      case 1 => (args(0), new File("./", "classpath.dot").getCanonicalPath)
      case 2 => (args(0), args(1))
      case _ => throw new IllegalArgumentException("CLI Parameter is only one or two.")
    }
  }

}
