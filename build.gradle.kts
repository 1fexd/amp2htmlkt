plugins {
    kotlin("jvm")
    java
    id("net.nemerosa.versioning")
}

allprojects {
    apply(plugin = "net.nemerosa.versioning")
    apply(plugin = "org.gradle.maven-publish")

    if (name != "bom") {
        apply(plugin = "org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
        maven(url = "https://jitpack.io")
    }

    if (name != "bom") {
        kotlin {
            jvmToolchain(17)
            if (name != "testing") {
                explicitApi()
            }
        }
    }

    group = "fe.amp2html"
    version = versioning.info.tag ?: versioning.info.full
}
