plugins {
    `version-catalog`
    `maven-publish`
}

group = "com.hayden"
version = "0.0.2"

repositories {
    mavenLocal()
}

catalog {
    versionCatalog {
        library("netflixDgsLib", "com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-gradle:6.0.3")
        library("springBoot", "org.springframework.boot:spring-boot-gradle-plugin:3.2.5")
        library("springDependencyManagement", "io.spring.gradle:dependency-management-plugin:1.1.4")
        library("kotlinGradle", "org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
        library("vertexAi", "com.google.cloud:google-cloud-vertexai:1.5.0")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}
