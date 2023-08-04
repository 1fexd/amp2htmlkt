plugins {
    kotlin("jvm") version "1.9.0"
    java
    `maven-publish`
    id("net.nemerosa.versioning") version "3.0.0"
}

group = "fe.amp2htmlkt"
version = versioning.info.tag ?: versioning.info.full

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("org.jsoup:jsoup:1.16.1")

    testImplementation(kotlin("test"))
    testImplementation("com.gitlab.grrfe.httpkt:core:13.0.0-alpha.34")
    testImplementation("com.gitlab.grrfe.httpkt:core-java8:13.0.0-alpha.34")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            version = project.version.toString()

            from(components["java"])
        }
    }
}
