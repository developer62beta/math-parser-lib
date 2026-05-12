
plugins {
    kotlin("jvm") version "1.9.23"
    `maven-publish`
}

group = "com.example"
version = "1.0.0"

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
            groupId = "com.example"
            artifactId = "math-parser"
            version = "1.0.0"
        }
    }
}
