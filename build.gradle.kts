plugins {
    id(libs.plugins.android.application.get().pluginId) apply false
    id(libs.plugins.kotlin.android.get().pluginId) apply false
    id(libs.plugins.android.library.get().pluginId) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id(libs.plugins.hilt.get().pluginId) apply false
}