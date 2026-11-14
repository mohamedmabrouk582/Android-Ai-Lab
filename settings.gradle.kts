pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Ai Lab"
include(":app")
include(":lab-api")
include(":lab-inference")
include(":lab-tensors")
include(":lab-tokens")
include(":lab-embeddings")
include(":lab-outputs")
include(":lab-transformers")
include(":lab-prompting")
include(":lab-rag")
include(":lab-agents")
include(":lab-evaluation")
include(":lab-quantization")
include(":lab-privacy")
include(":lab-mlkit-tasks")
include(":lab-prompt-api")
include(":lab-structured-output")
include(":lab-genai-tasks")
include(":lab-litert-cpu")
include(":lab-litert-gpu")
include(":lab-litert-runtime")
