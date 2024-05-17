import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.androidHilt
import com.example.convention.implementation
import com.example.convention.kapt
import com.example.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                apply("kotlin-kapt")
            }

            dependencies {
                implementation(libs.findBundle("hilt").get())
                kapt(libs.findLibrary("hilt-compiler").get())
            }
        }
    }
}