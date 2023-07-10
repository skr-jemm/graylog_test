plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation("jakarta.xml.bind:jakarta.xml.bind-api:3.0.0")
    implementation("com.sun.xml.bind:jaxb-impl:3.0.0")


    implementation("ch.qos.logback:logback-classic:1.4.7")
    implementation("de.siegmar:logback-gelf:4.0.2")
    implementation("io.vertx:vertx-web-client:4.2.5")


    //Json Schema vert.x
    implementation("io.vertx:vertx-json-schema:4.2.5")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}