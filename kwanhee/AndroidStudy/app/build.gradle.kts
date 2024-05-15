plugins {
    id("study.plugin.application")
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
    implementation(libs.junit)
    implementation(libs.androidx.test.ext)
    implementation(libs.androidx.test.espresso)
}