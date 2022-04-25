plugins {
    kotlin("jvm")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":call-back"))
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")
}
