plugins {
}

dependencies {
    api(platform("com.github.1fexd.super:platform:0.0.1"))

    testImplementation(kotlin("test"))
    testImplementation("com.gitlab.grrfe.httpkt:core")
}

publishing.publications.create<MavenPublication>("maven") {
    artifactId = "core"
    from(components["java"])
}
