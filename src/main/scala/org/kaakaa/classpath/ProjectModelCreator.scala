package org.kaakaa.classpath

import org.kaakaa.classpath.svn.SvnCommander
import org.kaakaa.classpath.ide.Project

/**
 * Created by kaakaa_hoe on 2014/06/02.
 */
object ProjectModelCreator {
  def apply(rootUrl: String) = {
    var projects = List.empty[Project]
    for (url <- SvnCommander.recursiveList(rootUrl)) {
      projects = new Project(url) :: projects
    }
    projects
  }
}
