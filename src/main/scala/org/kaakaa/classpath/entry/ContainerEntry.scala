package org.kaakaa.classpath.entry

import scala.xml.{Node, Elem}

/**
 * Created by kaakaa_hoe on 2014/05/29.
 */
case class ContainerEntry(entry: Node) extends ClasspathEntry {
  override def getPath(): String = {
    entry \ "@path" text
  }
}

