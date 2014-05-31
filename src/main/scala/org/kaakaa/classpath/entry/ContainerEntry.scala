package org.kaakaa.classpath.entry

import scala.xml.Elem

/**
 * Created by kaakaa_hoe on 2014/05/29.
 */
class ContainerEntry private(entry: Elem) extends ClasspathEntry {
}

object ContainerEntry {
  def apply(entry: Elem){
    new ContainerEntry(entry)
  }
}
