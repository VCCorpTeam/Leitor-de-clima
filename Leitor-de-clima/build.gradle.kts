plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("com.mysql:mysql-connector-j:8.1.0")
    testImplementation("com.sun.activation:javax.activation:1.2.0")
}

tasks.test {
    useJUnitPlatform()
}