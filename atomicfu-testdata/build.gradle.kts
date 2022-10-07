plugins {
  kotlin("multiplatform")
}

kotlin {
  jvm()
  js(IR) {
    nodejs()
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(project(":atomicfu"))
      }
    }
  }
}