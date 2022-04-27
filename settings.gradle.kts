dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Sample Clean Architecture"

include(
    ":app",
    ":core",
    ":presentation",
    ":feature:login",
    ":feature:home",
    ":feature:campaign",
    ":feature:transfer",
    ":feature:transaction",
    ":feature:account"
)