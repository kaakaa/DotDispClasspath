package org.kaakaa.classpath

import org.kaakaa.classpath.xml.JarNameFinder
import org.kaakaa.classpath.dot.DotFileCreater

/**
 * Created by kaakaa_hoe on 2014/06/01.
 */
class Main {
  def Main(args: Array[String]): Unit = {
    val rootUrl = args(0)
    val toPath = args(0)

    val projects = JarNameFinder.getDependencies(rootUrl)
    DotFileCreater.output(projects, toPath)
  }
}
