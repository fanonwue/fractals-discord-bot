plugins {
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.serialization") version "1.6.0"

    java
}

val ktorVersion = "1.6.4"

group = "dev.fractallove"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    // Kord Snapshots Repository
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    // Kord Extensions
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("dev.kord:kord-core:0.8.0-M7")
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.1-RC1")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization:$ktorVersion")
    implementation("org.jsoup:jsoup:1.14.3")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.0-RC")
//    implementation("com.discord4j:discord4j-core:3.2.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}