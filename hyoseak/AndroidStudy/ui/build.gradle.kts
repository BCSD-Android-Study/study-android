@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.study.hilt)
}

android {
    namespace = "com.example.ui"

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

    implementation(libs.androidx.core.ktx)
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.material)
    implementation (libs.androidx.constraintlayout)
    testImplementation (libs.juint)
    androidTestImplementation (libs.androidx.test.juint)
    androidTestImplementation (libs.androidx.test.espresso.core)
}