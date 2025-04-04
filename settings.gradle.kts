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

        mavenCentral() {
            content {
                includeGroup("com.google.dagger")
                includeGroup("com.google.dagger.hilt.android")
            }
            mavenContent {
                releasesOnly()
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Clone Pokedex"
include(":app")

include(":feature:detail")
include(":feature:home")

include(":core:navigation")
