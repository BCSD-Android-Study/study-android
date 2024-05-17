plugins {
    `kotlin-dsl` //이건 kts 파일에서만 되는거구나
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

dependencies {
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.android.gradle.tool)
}

gradlePlugin {
    plugins {
        register("AndroidApplicationPlugin") {
            id = "id.plugin.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}