plugins {
    kotlin("jvm") version "1.9.24"
    java
    `maven-publish`
    id("net.nemerosa.versioning") version "3.1.0"
}

group = "fe.amp2htmlkt"
version = versioning.info.tag ?: versioning.info.full

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("org.jsoup:jsoup:1.17.2")

    testImplementation(kotlin("test"))
    testImplementation("fe.httpkt:core")
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
