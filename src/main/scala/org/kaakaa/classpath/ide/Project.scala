package org.kaakaa.classpath.ide

import org.kaakaa.classpath.ide.entry.{ContainerEntry, LibraryEntry, SourceEntry, ClasspathEntry}
import scala.xml.{XML, NodeSeq}
import org.kaakaa.classpath.svn.SvnCommander

/**
 * Created by kaakaa_hoe on 2014/05/29.
 */
//class Project(name: String, classpaths: List[ClasspathEntry]) {
//  def this(url: String) = this("NoName", this.getClasspathEntries(url))

class Project(url: String) {
  val name = getProjectName(url)
  val classpaths = getClasspathEntries(url)

  def getProjectName(url: String): String = {
    val array = url.split('/')
    array(array.length - 2)
  }

  def getClassPathNames(): List[String] = {
    classpaths.map(c => c.getPath()).filter(n => n.length() > 2)
  }

  def getLineInDotFormat(): String = {
    val builder = new StringBuilder
    builder.append('[')
    for (cp <- classpaths if cp.getPath().length() > 2) {
      builder.append(cp.getPath())
      builder.append(',')
    }
    builder.setLength(builder.length() - 1)
    builder.append(']')

    val result = """{"type": "Project", "name": "%s", "depends": %s}""".format(name, builder.toString())
    result
  }

  def getClasspathEntries(url: String): List[ClasspathEntry] = {
    var list = List.empty[ClasspathEntry]

    getClasspathXML(url) foreach {
      entry => {
        entry \ "@kind" text match {
          case "lib" => list = new LibraryEntry(entry) :: list
          case "con" => list = new ContainerEntry(entry) :: list
          case "src" => list = new SourceEntry(entry) :: list
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

