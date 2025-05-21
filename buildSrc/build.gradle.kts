plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:8.10.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.0-RC")
    implementation("com.android.tools.build:gradle-api:8.10.0")
}