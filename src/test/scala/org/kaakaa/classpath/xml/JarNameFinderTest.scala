package org.kaakaa.classpath.xml

import org.scalatest.{FunSpec, FunSuite}

/**
 * Created by kaakaa_hoe on 2014/05/26.
 */
class JarNameFinderTest extends FunSpec {
  describe("test"){
    it("dependencies"){
      val sample = new JarNameFinder
      print(sample.getDependencies())
    }
  }
}
