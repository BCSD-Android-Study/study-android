plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("AndroidApplicationPlugin") {
            id = "study.plugin.application"
            implementationClass ="AndroidApplicationConventionPlugin"
        }
        register("AndroidApplicationComposePlugin") {
            id = "study.plugin.android.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }
}