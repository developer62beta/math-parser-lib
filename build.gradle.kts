
plugins {
    kotlin("jvm") version "1.9.23"
    `maven-publish`
}

group = "com.developer62"
version = "1.0.3"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.developer62"
            artifactId = "math-parser"
            version = "1.0.3"
        }
    }
}
