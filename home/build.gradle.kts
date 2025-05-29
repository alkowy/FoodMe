plugins {
    alias(libs.plugins.kotlin.compose)
    id("base-module-config")
}

android {
    namespace = "com.azmarzly.home"
}

dependencies {
    implementation(project(":authentication"))
    implementation(project(":profile"))
    implementation(project(":core"))
}