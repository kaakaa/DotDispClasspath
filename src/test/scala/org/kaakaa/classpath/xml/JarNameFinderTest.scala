package org.kaakaa.classpath.xml

import org.scalatest.{FunSpec, FunSuite}
import java.io.PrintWriter

/**
 * Created by kaakaa_hoe on 2014/05/26.
 */
class JarNameFinderTest extends FunSpec {
  describe("test"){
    it("dependencies"){
      val sample = new JarNameFinder
      print(sample.getDependencies())
    }

    it ("get dot text"){
      val out = new PrintWriter("C:\\Users\\kaakaa_hoe\\test.dot")
      out.print(new JarNameFinder().getDotText)
      out.close()
    }
  }
}
