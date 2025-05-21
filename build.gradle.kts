plugins {
    id(libs.plugins.android.application.get().pluginId) apply false
    id(libs.plugins.kotlin.android.get().pluginId) apply false
    id(libs.plugins.android.library.get().pluginId) apply false
    alias(libs.plugins.kotlin.compose) apply false
}