plugins {
    `build-scan`
    kotlin("jvm") version "1.3.61"
}

group = "com.github.sylux6.kongou"
version = "v1.0.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
    implementation("com.github.kittinunf.fuel:fuel:2.2.1")
    implementation("com.github.kittinunf.fuel:fuel-json:2.2.1")
    implementation("org.json", "json", "20190722")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"

    publishAlways()
}