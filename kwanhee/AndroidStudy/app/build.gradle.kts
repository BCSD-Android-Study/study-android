plugins {
    id("study.plugin.application")
    id("study.plugin.android.compose")
}

android {
    namespace = "com.koreatech.android_study"

    defaultConfig {
        applicationId = "com.koreatech.android_study"
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
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)

    // compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)

    // test
    implementation(libs.junit)
    implementation(libs.androidx.compose.ui.test)

    // android test
    implementation(libs.androidx.test.ext)
    implementation(libs.androidx.test.espresso)
}