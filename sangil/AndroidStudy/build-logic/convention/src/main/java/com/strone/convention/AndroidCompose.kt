package com.strone.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {
        buildFeatures.compose = true

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().requiredVersion
        }
    }

    dependencies {
        "implementation"(platform(libs.findLibrary("compose.bom").get()))
        "androidTestImplementation"(platform(libs.findLibrary("compose.bom").get()))
        "implementation"(libs.findBundle("compose").get())
        "androidTestImplementation"(libs.findBundle("compose.test").get())

    }
}
