plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Jackson Dataformat XML para trabajar con XML
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.0")

    // Otras dependencias si las necesitas
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.9.3")

    // Para pruebas con JUnit 5
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.9.3")

    // Mockito para crear mocks
    testImplementation ("org.mockito:mockito-core:4.11.0")
    testImplementation ("org.mockito:mockito-junit-jupiter:4.11.0")

}

tasks.test {
    useJUnitPlatform()
}