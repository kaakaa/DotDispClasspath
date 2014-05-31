package org.kaakaa.classpath.xml

import scala.xml.{XML, Elem, NodeSeq}
import org.kaakaa.classpath.SvnCommander
import org.kaakaa.classpath.entry.{ClasspathEntry, ContainerEntry, LibraryEntry}
import java.awt.event.ContainerEvent
import scala.collection.JavaConverters._

/**
 * Created by kaakaa_hoe on 2014/05/26.
 */
class JarNameFinder {
  val rootUrl = "http://localhost/svn/SampleProject/"

  def getDependencies(): String = {
    var builder = List[ClasspathEntry]()

    SvnCommander.recursiveList(rootUrl) foreach {
      getClasspathXML(_) foreach {
        entry => {
          entry \ "@kind" text match {
            case "lib" => builder = new LibraryEntry(entry) :: builder
            case "con" => builder = new ContainerEntry(entry) :: builder
            case _ =>
          }
        }
      }
    }
    builder.toString()
  }

  def getClasspathXML(url: String): NodeSeq = {
    XML loadString SvnCommander.cat(rootUrl + url)
  }
}
