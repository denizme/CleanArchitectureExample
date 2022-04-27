plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
    id(Plugins.navigationSafeargs)
}

android {
    compileSdk = Config.compileSdkVersion
    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        applicationId = Config.applicationId
        versionCode = Config.versionCode
        versionName = Config.versionName
    }

    flavorDimensions.add(Dimensions.default)

    productFlavors {
        create("dev") {
            dimension = Dimensions.default
            buildConfigField("String", "BASE_URL", Dev.BASE_URL)
        }
        create("prod") {
            dimension = Dimensions.default
            buildConfigField("String", "BASE_URL", Prod.BASE_URL)
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":feature:home"))
    implementation(project(":feature:login"))
    implementation(project(":feature:campaign"))
    implementation(project(":feature:transfer"))
    implementation(project(":feature:transaction"))
    implementation(project(":feature:account"))
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompiler)
}