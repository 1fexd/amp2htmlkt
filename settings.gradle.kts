rootProject.name = "amp2html"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        kotlin("jvm") version "1.9.24"
        id("org.gradle.maven-publish")
        id("net.nemerosa.versioning") version "3.1.0"
    }
}

include("bom", "core")
