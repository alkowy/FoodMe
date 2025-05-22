plugins {
    id("base-module-config")
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.azmarzly.authentication"
}

dependencies {
    implementation(project(":core"))

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.identity.googleid)
}