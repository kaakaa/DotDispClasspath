package org.kaakaa.classpath

import org.kaakaa.classpath.entry.ClasspathEntry

/**
 * Created by kaakaa_hoe on 2014/05/29.
 */
class Project private(classpaths: List[ClasspathEntry]) {
}

object Project {
  def apply(list: List[ClasspathEntry]) {
    new Project(list)
  }
}
