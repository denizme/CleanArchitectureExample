/*
 * App configuration
 */
object Config {
    const val applicationId = "com.example"
    const val minSdkVersion = Versions.minSdkVersion
    const val targetSdkVersion = Versions.targetSdkVersion
    const val compileSdkVersion = Versions.compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val testInstrumentationRunner = "com.example.HiltTestRunner"
}

/*
 * Flavor Dimensions
 */
object Dimensions {
    const val default = "default"
}

/*
 * Product Flavors
 */
object Prod {
    const val BASE_URL = "\"https://api.github.com\""
}

object Dev {
    const val BASE_URL = "\"https://api.github.com\""
    const val suffix = ".dev"
    const val versionNameSuffix = suffix
    const val applicationIdSuffix = suffix
    const val packageName = Config.applicationId + applicationIdSuffix
}