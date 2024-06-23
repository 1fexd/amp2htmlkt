plugins {
}

dependencies {
    implementation("org.jsoup:jsoup:1.17.2")

    testImplementation(kotlin("test"))
    testImplementation("com.gitlab.grrfe.httpkt:core:13.0.0-alpha.62")
}

publishing.publications.create<MavenPublication>("maven") {
    artifactId = "core"
    from(components["java"])
}
