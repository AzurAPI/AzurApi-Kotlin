val atriumVersion = "0.12.0"
val javaStringSimilarityVersion = "2.0.0"
val jsonVersion = "20200518"
val kotlinVersion = "1.5.0"
val mockkVersion = "1.10.0"
val fuelVersion = "2.2.1"
val spekVersion = "2.0.9"

plugins {
    java
    maven
    kotlin("jvm") version "1.5.0"
    id("org.jmailen.kotlinter") version "3.4.4"
}

group = "com.github.AzurApi"
version = "3.1.6 - Beta"   //DISCUSS not sure what number to put lmao

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    jcenter()
}

//TODO check for update
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.kittinunf.fuel:fuel:$fuelVersion")
    implementation("com.github.kittinunf.fuel:fuel-json:$fuelVersion")
    implementation("org.json:json:$jsonVersion")
    implementation("info.debatty:java-string-similarity:$javaStringSimilarityVersion")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:$atriumVersion")
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
}