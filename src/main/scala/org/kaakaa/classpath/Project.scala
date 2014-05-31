package org.kaakaa.classpath

import org.kaakaa.classpath.entry.ClasspathEntry

/**
 * Created by kaakaa_hoe on 2014/05/29.
 */
class Project(name: String, classpaths: List[ClasspathEntry]) {
  def getLineInDotFormat(): List[String] = {
    var result = List.empty[String]
    for(cp <- classpaths) {
      result = "%s -> %s;".format(name, cp.getPath()) :: result
    }
    result
  }
}

