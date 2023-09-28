plugins {
    id("java")
    id("application")
    id("java-library")
}


group = "org.anazworth"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hibernate:hibernate-core:6.3.0.Final")
    implementation("jakarta.transaction:jakarta.transaction-api")
    implementation("com.mysql:mysql-connector-j:8.1.0")
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}


tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.anazworth.Main")
}