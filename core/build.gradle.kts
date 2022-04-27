plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}

android {
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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

    testOptions {
        unitTests.apply {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    api(Libraries.coroutineAndroid)
    api(Libraries.material)
    api(Libraries.retrofit)
    implementation(Libraries.retrofitGsonConverter)
    implementation(Libraries.okhttp)
    implementation(Libraries.loggingInterceptor)
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompiler)
    api(Libraries.androidxCore)
    api(Libraries.androidxAppcompat)
    api(Libraries.lifecycleLiveData)
    api(Libraries.lifecycleRuntime)
    api(Libraries.lifecycleViewModel)
    api(Libraries.androidxFragment)
    api(Libraries.androidxNavigation)
    api(Libraries.androidxNavigationUI)
}
