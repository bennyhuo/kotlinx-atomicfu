plugins {
  kotlin("multiplatform")
}

kotlin {
  jvm()
  js(LEGACY) {
    nodejs()
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        compileOnly(project(":atomicfu"))
      }
    }
  }
}