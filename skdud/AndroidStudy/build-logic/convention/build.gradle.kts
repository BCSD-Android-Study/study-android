plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
}

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    register("AndroidApplicationComposePlugin") {
        id = "study.plugin.android.compose"
        implementationClass = "AndroidApplicationComposeConventionPlugin"
    }
    register("AndroidHiltPlugin") {
        id = "study.plugin.android.hilt"
        implementationClass = "AndroidHiltConventionPlugin"
    }
    register("AndroidLibraryPlugin") {
        id = "study.plugin.android.library"
        implementationClass = "AndroidLibraryConventionPlugin"
    }
    }
}

include(":app")
