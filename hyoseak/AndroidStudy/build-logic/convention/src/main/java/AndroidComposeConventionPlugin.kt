import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.example.convention.androidCompose
import com.example.convention.androidTestImplementation
import com.example.convention.debugImplementation
import com.example.convention.implementation
import com.example.convention.kapt
import com.example.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class  AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-parcelize")
                apply("org.jetbrains.kotlin.android")
            }
            val extension = extensions.getByType<BaseAppModuleExtension>()
            extensions.configure<ApplicationExtension> {
                androidCompose(extension)
            }
            dependencies {
                implementation(platform(libs.findLibrary("compose.bom").get()))
                implementation(libs.findBundle("compose").get())
                debugImplementation(libs.findBundle("compose.debug.test").get())
                androidTestImplementation(libs.findLibrary("compose.ui.test.manifest").get())
            }
        }
    }
}