package org.kaakaa.scala

import org.scalatest.{FunSpec, FunSuite}
import org.kaakaa.classpath.SvnCommander

/**
 * Created by kaakaa_hoe on 2014/05/27.
 */
class SvnCommanderTest extends FunSpec {
  describe("svn command test"){
    it("list"){
      println(SvnCommander.recursiveList("http://localhost/svn/SampleProject"))
    }
    it("list not authorized"){
      println(SvnCommander.list("http://localhost/svn/SampleProject"))
    }
  }
}
