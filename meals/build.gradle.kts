plugins {
    alias(libs.plugins.kotlin.compose)
    id("base-module-config")
}

android {
    namespace = "com.azmarzly.meals"
}

dependencies {

    implementation(project(":core"))
}