package org.kaakaa.classpath

import org.scalatest.FunSpec
import java.io.File

/**
 * Created by kaakaa_hoe on 2014/06/02.
 */
class Main$Test extends FunSpec {
  describe("main") {
    it("one argument") {
      Main.main(Array("svn://localhost/Users/kaakaa_hoe/Documents/Learning/Scala/DotDispClasspath/test/"))
    }
    it("two argument") {
      Main.main(Array("svn://localhost/Users/kaakaa_hoe/Documents/Learning/Scala/DotDispClasspath/test/", new File(".", "src/main/resources/d3-process-map/data/DispClasspath/object.json").getAbsolutePath()))
    }
  }
}
