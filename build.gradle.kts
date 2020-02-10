val kotlinVersion = "1.3.61"
val fuelVersion = "2.2.1"
val spekVersion = "2.0.9"

plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.3.61"
    id("org.jmailen.kotlinter") version "2.3.0"
}

group = "com.github.AzurApi"
version = "2.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.kittinunf.fuel:fuel:$fuelVersion")
    implementation("com.github.kittinunf.fuel:fuel-json:$fuelVersion")
    implementation("org.json", "json", "20190722")
    implementation("info.debatty", "java-string-similarity", "1.2.1")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:0.9.1")
}

tasks {
    test {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}