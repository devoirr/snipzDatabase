plugins {
    kotlin("jvm") version "2.1.20"
}

group = "me.snipz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.zaxxer:HikariCP:6.3.0")
}

kotlin {
    jvmToolchain(21)
}