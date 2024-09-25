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
    implementation("com.opencsv:opencsv:4.6")
    /*
    testImplementation("org.mockito.core:mockito-core:5.12.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.11.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.3.1")
     */
}

tasks.test {
    useJUnitPlatform()
}