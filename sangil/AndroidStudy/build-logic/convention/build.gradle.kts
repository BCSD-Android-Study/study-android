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
}

gradlePlugin {
    plugins {
        register("AndroidHiltConvention") {
            id = "plugin.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("AndroidApplicationComposeConvention") {
            id = "plugin.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }
}