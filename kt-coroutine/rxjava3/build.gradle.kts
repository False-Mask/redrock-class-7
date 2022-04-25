plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    // https://mvnrepository.com/artifact/io.reactivex.rxjava3/rxjava
    implementation("io.reactivex.rxjava3:rxjava:3.1.3")

}