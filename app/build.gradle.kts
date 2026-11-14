plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.mabrouk.ailab"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.mabrouk.ailab"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":lab-api"))
    implementation(project(":lab-inference"))
    implementation(project(":lab-tensors"))
    implementation(project(":lab-tokens"))
    implementation(project(":lab-embeddings"))
    implementation(project(":lab-outputs"))
    implementation(project(":lab-transformers"))
    implementation(project(":lab-prompting"))
    implementation(project(":lab-rag"))
    implementation(project(":lab-agents"))
    implementation(project(":lab-evaluation"))
    implementation(project(":lab-quantization"))
    implementation(project(":lab-privacy"))
    implementation(project(":lab-mlkit-tasks"))
    implementation(project(":lab-prompt-api"))
    implementation(project(":lab-structured-output"))
    implementation(project(":lab-genai-tasks"))
    implementation(project(":lab-litert-cpu"))
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
