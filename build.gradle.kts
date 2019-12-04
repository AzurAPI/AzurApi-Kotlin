val kotlinVersion = "1.3.61"
val fuelVersion = "2.2.1"
val kotlintestVersion = "3.4.2"

plugins {
    kotlin("jvm") version "1.3.61"
}

group = "com.github.azurapi.azurapikotlin"
version = "v1.0.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.kittinunf.fuel:fuel:$fuelVersion")
    implementation("com.github.kittinunf.fuel:fuel-json:$fuelVersion")
    implementation("org.json", "json", "20190722")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:$kotlintestVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}