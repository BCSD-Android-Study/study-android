@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.study.hilt)
}

android {
    namespace = "com.example.ui"

    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.material)
    implementation (libs.androidx.constraintlayout)
    testImplementation (libs.juint)
    androidTestImplementation (libs.androidx.test.juint)
    androidTestImplementation (libs.androidx.test.espresso.core)
}