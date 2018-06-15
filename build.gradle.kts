import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "fr.octo.craft"
version = "1.0-SNAPSHOT"

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.10"

    repositories {
        mavenCentral()
    }
    
    dependencies {
        classpath(kotlinModule("gradle-plugin", kotlin_version))
    }
}

apply {
    plugin("java")
    plugin("kotlin")
}

val kotlin_version: String by extra
val junitVersion = "5.0.0"
val junitPlatformVersion = "1.0.0"
val assertJVersion = "3.10.0"
val mockitoVersion = "2.18.3"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlinModule("stdlib-jdk8", kotlin_version))


    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testCompile("org.mockito:mockito-junit-jupiter:$mockitoVersion")
    testCompile("org.assertj:assertj-core:$assertJVersion")

    runtime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    runtime("org.junit.platform:junit-platform-console:$junitPlatformVersion")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

