plugins {
}

dependencies {
    api(platform("com.github.1fexd:super:0.0.2"))

    testImplementation(kotlin("test"))
    testImplementation("com.gitlab.grrfe.httpkt:core")
}

publishing.publications.create<MavenPublication>("maven") {
    artifactId = "core"
    from(components["java"])
}
