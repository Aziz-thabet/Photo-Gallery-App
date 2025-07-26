// build.gradle.kts (Module: app)
plugins {
    id("com.android.application") // plugin for Android applications
    id("org.jetbrains.kotlin.android") // Kotlin Android plugin
    id("kotlin-kapt") // Kotlin Annotation Processing Tool for Room, Hilt, Glide
    id("com.google.dagger.hilt.android") // Hilt plugin
}

android {
    namespace = "com.example.photogalleryapp"
    compileSdk = 34 // Use a recent compile SDK version

    defaultConfig {
        applicationId = "com.example.photogalleryapp"
        minSdk = 24 // Minimum SDK version
        targetSdk = 34 // Target SDK version
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // Ensure testInstrumentationRunner is set for Hilt testing if needed later
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true // Enable View Binding
    }
}

dependencies {
    // AndroidX Core & UI
    implementation(libs.androidx.core.ktx.v1131) // Latest stable version
    implementation(libs.androidx.appcompat.v161) // Latest stable version
    implementation(libs.material) // Latest stable version
    implementation(libs.androidx.activity.ktx) // Latest stable version
    implementation(libs.androidx.constraintlayout.v214) // Latest stable version

    // Lifecycle components (for ViewModel and LiveData/Flow)
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v283) // Latest stable version
    implementation(libs.androidx.lifecycle.livedata.ktx.v283) // Latest stable version
    implementation(libs.androidx.lifecycle.runtime.ktx.v283) // For lifecycleScope and repeatOnLifecycle

    // Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.core.v181) // Latest stable version
    implementation(libs.kotlinx.coroutines.android.v181) // Latest stable version

    // Networking - Retrofit and Gson
    implementation(libs.retrofit) // Latest stable version
    implementation(libs.converter.gson) // Latest stable version
    implementation(libs.gson) // Explicit Gson dependency

    // Image Loading - Glide
    implementation(libs.glide) // Latest stable version
    kapt("com.github.bumptech.glide:compiler:4.16.0") // Annotation processor for Glide

    // Room Database
    implementation(libs.androidx.room.runtime) // Latest stable version
    implementation(libs.androidx.room.ktx) // For Kotlin Coroutines with Room
    kapt(libs.androidx.room.compiler) // Annotation processor for Room

    // Hilt Dependency Injection
    implementation(libs.hilt.android) // Latest stable version
    kapt(libs.hilt.android.compiler) // Hilt annotation processor
    // Hilt for ViewModel integration (important for by viewModels())
    implementation(libs.androidx.hilt.navigation.fragment) // Latest stable version
    kapt(libs.androidx.hilt.compiler) // AndroidX Hilt annotation processor

    // Unit Testing Dependencies
    testImplementation(libs.junit) // JUnit 4
    testImplementation(libs.kotlinx.coroutines.test.v181) // Coroutines test utilities
    testImplementation(libs.mockk) // Mocking framework for Kotlin
    testImplementation(libs.androidx.core.testing) // For InstantTaskExecutorRule
    testImplementation(libs.truth) // Optional: For more readable assertions
    testImplementation(kotlin("test"))

}
