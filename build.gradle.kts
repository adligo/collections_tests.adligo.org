/*
  To build this project use one of the matrix parent builds i.e.
  {@ link <a href="https://github.com/adligo/jse8-core.adligo.org">
    https://github.com/adligo/jse8-core.adligo.org
  </a>}<br/>
  Or <br/>
  {@ link <a href="https://github.com/adligo/jse11-core.adligo.org">
    https://github.com/adligo/jse11-core.adligo.org
  </a>}<br/>
 */

plugins {
  `maven-publish`
  eclipse
  java
  signing
}

sourceSets {
  test {
    java {
      srcDirs("src")
    }
  }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

