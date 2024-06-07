import com.android.build.api.dsl.LibraryExtension
import com.koreatech.convention.configureKotlinAndroid
import com.koreatech.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.findPlugin("androidLibrary").get().get().pluginId)
                apply(libs.findPlugin("kotlin").get().get().pluginId)
            }
            extensions.configure<LibraryExtension>() {
                configureKotlinAndroid(this)

                defaultConfig {
                    consumerProguardFiles("consumer-rules.pro")
                }
            }
        }
    }
}