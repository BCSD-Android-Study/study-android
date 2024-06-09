plugins {
    `kotlin-dsl`
}

group = "com.wateralsie.buildlogic"

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
        register("androidApplicationKotlin") {
            id = "com.wateralsie.application"
            implementationClass = "com.wateralsie.convention.AndroidApplicationKotlinPlugin"
        }
        register("androidCompose") {
            id = "com.wateralsie.compose"
            implementationClass = "com.wateralsie.convention.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "com.wateralsie.hilt"
            implementationClass = "com.wateralsie.convention.AndroidHiltPlugin"
        }
    }
}