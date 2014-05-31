package org.kaakaa.classpath.entry

import scala.xml.Node

/**
 * Created by kaakaa_hoe on 2014/05/31.
 */
trait ClasspathEntry {
  val entry: Node
  def getPath(): String = {
    getResourceName(entry)
  }
  def unapply(a: ContainerEntry): Option[String] = Some(a.entry \ "@kind" text)
}

