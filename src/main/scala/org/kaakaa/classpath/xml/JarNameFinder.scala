package org.kaakaa.classpath.xml

import scala.xml.{XML, NodeSeq}
import org.kaakaa.classpath.{Project, SvnCommander}
import org.kaakaa.classpath.entry.{ClasspathEntry, ContainerEntry, LibraryEntry}
import org.kaakaa.classpath.dot.DotFileCreater

/**
 * Created by kaakaa_hoe on 2014/05/26.
 */
object JarNameFinder {
  def getDependencies(rootUrl: String): List[Project] = {
    var projects = List.empty[Project]
    for (url <- SvnCommander.recursiveList(rootUrl)) {
      projects = new Project("NoName", getClasspathEntries(url)) :: projects

    }
    projects
  }

  def getClasspathEntries(url: String): List[ClasspathEntry] = {
    var list = List.empty[ClasspathEntry]

    getClasspathXML(url) foreach {
      entry => {
        entry \ "@kind" text match {
          case "lib" => list = new LibraryEntry(entry) :: list
          case "con" => list = new ContainerEntry(entry) :: list
          case _ =>
        }
      }
    }
    list
  }

  def getClasspathXML(url: String): NodeSeq = {
    val classpath = XML loadString SvnCommander.cat(url)
    classpath \ "classpathentry"
  }
}
