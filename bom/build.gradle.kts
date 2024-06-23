plugins {
    `java-platform`
}

dependencies {
    constraints {
        api("com.gitlab.grrfe.gson-ext:core:16.0.0-gson2-koin3")
        api("org.jsoup:jsoup:1.17.2")
    }
}

publishing.publications.create<MavenPublication>("maven") {
    artifactId = "bom"
    from(components["javaPlatform"])
}
