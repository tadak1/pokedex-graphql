plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.example.animegraphql.android"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc01"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("com.apollographql.apollo3:apollo-normalized-cache:3.0.0")
    implementation("io.insert-koin:koin-android:3.1.4")
    implementation("androidx.compose.ui:ui:1.1.0-rc01")
    implementation("androidx.compose.compiler:compiler:1.1.0-rc02")
    implementation("androidx.compose.foundation:foundation-layout:1.1.0-rc01")
    implementation("androidx.navigation:navigation-compose:2.4.0-rc01")
    implementation("androidx.compose.material:material:1.1.0-rc01")
    implementation("androidx.compose.animation:animation:1.1.0-rc01")
    implementation("androidx.compose.ui:ui-tooling:1.1.0-rc01")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.0-rc01")
}