package org.kaakaa.classpath

import org.scalatest.FunSpec

/**
 * Created by kaakaa_hoe on 2014/06/02.
 */
class Main$Test extends FunSpec {
  describe("main"){
    it("one argument"){
      Main.main(Array("svn://localhost/Users/kaakaa_hoe/Documents/Learning/Scala/DotDispClasspath/test/"))
    }
  }
}
