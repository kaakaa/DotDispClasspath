package org.kaakaa.classpath

import scala.xml.Node

/**
 * Created by kaakaa_hoe on 2014/05/31.
 */
package object entry {
  def getResourceName(entry: Node): String = {
    "\"%s\"".format(getPath(entry).split("/").last)
  }

  def getPath(entry: Node): String = {
    entry \ "@path" text
  }
}
