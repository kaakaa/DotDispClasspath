package org.kaakaa.classpath.xml

import scala.xml.{XML, NodeSeq}
import org.kaakaa.classpath.{Project, SvnCommander}
import org.kaakaa.classpath.entry.{ClasspathEntry, ContainerEntry, LibraryEntry}

/**
 * Created by kaakaa_hoe on 2014/05/26.
 */
class JarNameFinder {
  val rootUrl = "http://localhost/svn/SampleProject/"

  def getDependencies(): List[Project] = {
    var projects = List.empty[Project]
    for(url <- SvnCommander.recursiveList(rootUrl)) {
      projects = new Project(getClasspathEntries _) :: projects
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
    XML loadString SvnCommander.cat(rootUrl + url)
  }
}
