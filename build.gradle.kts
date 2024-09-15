plugins {
    `version-catalog`
    `maven-publish`
}

group = "com.hayden"
version = "0.0.2"

repositories {
    mavenLocal()
}

project.ext["springCloudVersion"] = "2023.0.3"
project.ext["springBootVersion"] = "3.3.3"
project.ext["springIntegrationVersion"] = "6.2.1"
project.ext["openTelemetryVersion"] = "1.35.0"

catalog {
    versionCatalog {
        library("netflixDgsLib", "com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-gradle:6.0.3")
        library("springBoot", "org.springframework.boot:spring-boot-gradle-plugin:${property("springBootVersion")}")
        library("springDependencyManagement", "io.spring.gradle:dependency-management-plugin:1.1.4")
        library("kotlinGradle", "org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")

        library("aspectJWeaver", "org.aspectj:aspectjweaver:1.9.7")

        library("vertexAi", "com.google.cloud:google-cloud-vertexai:1.5.0")

        library("dglPytorchJni", "ai.djl.pytorch:pytorch-jni:2.0.1-0.25.0")
        library("dglPytorchEngine", "ai.djl.pytorch:pytorch-engine:0.25.0")
        library("dglPytorchNativeCpu", "ai.djl.pytorch:pytorch-native-cpu:2.0.1")
        library("dglApi", "ai.djl:api:0.24.0")
        bundle("dgl", mutableListOf("dglPytorchJni", "dglPytorchEngine", "dglPytorchNativeCpu", "dglApi"))


        library("bcProvider", "org.bouncycastle:bcprov-jdk18on:1.76")
        library("bcTls", "org.bouncycastle:bctls-jdk18on:1.76")
        library("bcPkix", "org.bouncycastle:bcpkix-jdk18on:1.76")
        bundle("bc", mutableListOf("bcProvider", "bcTls", "bcPkix"))

        library("dgsCodegenCore","com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-core:6.1.4")
        library("dgsMocking", "com.netflix.graphql.dgs:graphql-dgs-mocking:8.2.5")
        library("dgsApolloFederation", "com.apollographql.federation:federation-graphql-java-support:2.1.0")
        bundle("dgs", mutableListOf("dgsCodegenCore", "dgsMocking", "dgsApolloFederation"))


        library("droolsEngine", "org.drools:drools-engine:8.44.0.Final")
        library("droolsMvel", "org.drools:drools-mvel:8.44.0.Final")
        bundle("drools", mutableListOf("droolsEngine", "droolsMvel"))

        library("opentelemtrySemConv", "io.opentelemetry.semconv:opentelemetry-semconv:1.23.1-alpha")
        library("opentelemtryLogback", "io.opentelemetry.instrumentation:opentelemetry-logback-appender-1.0:2.1.0-alpha")
        library("opentelemtryInstrumentationApi", "io.opentelemetry.instrumentation:opentelemetry-instrumentation-api:2.1.0")
        library("opentelemtrySpringBootStarter", "io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter:1.22.1-alpha")
        library("opentelemtryAnnotations", "io.opentelemetry.instrumentation:opentelemetry-instrumentation-annotations:2.1.0")
        library("opentelemtryJdbc", "io.opentelemetry.instrumentation:opentelemetry-jdbc:2.1.0-alpha")
        bundle("opentelemetry", mutableListOf(
            "opentelemtrySemConv", "opentelemtryLogback", "opentelemtryInstrumentationApi",
            "opentelemtrySpringBootStarter", "opentelemtryAnnotations", "opentelemtryJdbc"
        ))


        library("springCloudBom", "org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        library("springBootDependenciesBom", "org.springframework.boot:spring-boot-dependencies:${property("springBootVersion")}")
        library("springIntegrationBom", "org.springframework.integration:spring-integration-bom:${property("springIntegrationVersion")}")
        library("openTelemetryBom", "io.opentelemetry:opentelemetry-bom:${property("openTelemetryVersion")}")
        bundle("externalBoms", mutableListOf(
            "springCloudBom", "springBootDependenciesBom",
            "springIntegrationBom", "openTelemetryBom"
        ))

    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}