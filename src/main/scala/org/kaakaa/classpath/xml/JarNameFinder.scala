package org.kaakaa.classpath.xml

import scala.xml.{Elem, NodeSeq, NodeBuffer}

/**
 * Created by kaakaa_hoe on 2014/05/26.
 */
class JarNameFinder {

  def getDependencies(): String = {
    var builder = List[String]()
    getClasspathEntry() foreach {
      entry => {
        if("lib" == (entry \ "@kind").text){
          builder =  (entry \ "@path").text :: builder
        }
      }
    }
    builder.toString()
  }

  def getClasspathEntry(): NodeSeq = {
    getXml()  \ "classpathentry"
  }

  def getXml(): Elem = {
      <classpath>
        <classpathentry kind="output" path="bin"/>
        <classpathentry kind="src" path="src/main/java"/>
        <classpathentry kind="src" path="src/test/java"/>
        <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER" exported="true"/>
        <classpathentry sourcepath="/home/vagrant/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.5/654135274d4c27132ea208a4ec07f344bdb83bcb/slf4j-api-1.7.5-sources.jar" kind="lib" path="/home/vagrant/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.5/6b262da268f8ad9eff941b25503a9198f0a0ac93/slf4j-api-1.7.5.jar" exported="true"/>
        <classpathentry sourcepath="/home/vagrant/.gradle/caches/modules-2/files-2.1/junit/junit/4.11/28e0ad201304e4a4abf999ca0570b7cffc352c3c/junit-4.11-sources.jar" kind="lib" path="/home/vagrant/.gradle/caches/modules-2/files-2.1/junit/junit/4.11/4e031bb61df09069aeb2bffb4019e7a5034a4ee0/junit-4.11.jar" exported="true"/>
        <classpathentry sourcepath="/home/vagrant/.gradle/caches/modules-2/files-2.1/org.hamcrest/hamcrest-core/1.3/1dc37250fbc78e23a65a67fbbaf71d2e9cbc3c0b/hamcrest-core-1.3-sources.jar" kind="lib" path="/home/vagrant/.gradle/caches/modules-2/files-2.1/org.hamcrest/hamcrest-core/1.3/42a25dc3219429f0e5d060061f71acb49bf010a0/hamcrest-core-1.3.jar" exported="true"/>
      </classpath>
  }
}
