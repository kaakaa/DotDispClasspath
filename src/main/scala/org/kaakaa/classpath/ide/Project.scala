package org.kaakaa.classpath.ide

import org.kaakaa.classpath.ide.entry.{ContainerEntry, LibraryEntry, ClasspathEntry}
import scala.xml.{XML, NodeSeq}
import org.kaakaa.classpath.svn.SvnCommander

/**
 * Created by kaakaa_hoe on 2014/05/29.
 */
//class Project(name: String, classpaths: List[ClasspathEntry]) {
//  def this(url: String) = this("NoName", this.getClasspathEntries(url))

class Project(url: String) {
  val name = "NoName"
  val classpaths = getClasspathEntries(url)

  def getLineInDotFormat(): List[String] = {
    var result = List.empty[String]
    for (cp <- classpaths) {
      result = "%s -> %s;".format(name, cp.getPath()) :: result
    }
    result
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

