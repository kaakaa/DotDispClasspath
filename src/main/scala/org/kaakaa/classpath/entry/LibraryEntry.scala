package org.kaakaa.classpath.entry

import scala.xml.Elem

/**
 * Created by kaakaa_hoe on 2014/05/29.
 */
class LibraryEntry private (entry: Elem) extends ClasspathEntry {
}

object LibratyEntry{
  def apply(entry: Elem){
    new LibraryEntry(entry)
  }
}
