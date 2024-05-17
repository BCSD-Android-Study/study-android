package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun androidProject(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    (commonExtension as? ApplicationExtension)?.let {
        it.defaultConfig.targetSdk = 34
    }

    commonExtension.apply {
        compileSdk = 34

        defaultConfig {
            minSdk = 23

            testInstrumentationRunner = "androidxt.test.runner.AndroidJUnitRunner"
            vectorDrawables.useSupportLibrary = true
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_18
            targetCompatibility = JavaVersion.VERSION_18
        }

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_18.toString()
        }
    }

}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}
