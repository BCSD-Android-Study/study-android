package com.wateralsie.convention

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        with(plugins) {
            apply("org.jetbrains.kotlin.plugin.compose")
        }
        extensions.getByType<BaseExtension>().apply {
            buildFeatures.apply {
                compose = true
            }
            composeOptions.apply {
                kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().requiredVersion
            }
        }
        dependencies {
            "implementation"(platform(libs.findLibrary("compose-bom").get()))
            "implementation"(libs.findBundle("compose").get())
        }
    }
}