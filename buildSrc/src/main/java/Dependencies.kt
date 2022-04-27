
object Libraries {

    //Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"

    //androidX
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycleVersion}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycleVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycleVersion}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
    const val androidxFragment = "androidx.fragment:fragment-ktx:${Versions.androidxFragment}"
    const val androidxNavigation = "androidx.navigation:navigation-fragment-ktx:${Versions.androidXNavigationVersion}"
    const val androidxNavigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.androidXNavigationVersion}"

    const val material = "com.google.android.material:material:1.5.0"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val loggingInterceptor= "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
}


object TestLibraries {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0"
    const val junit = "junit:junit:4.+"
    const val mockk ="io.mockk:mockk:1.12.0"
    const val truth ="androidx.test.ext:truth:1.4.0"
    const val coreTesting ="androidx.arch.core:core-testing:2.1.0"
    const val mockWebserver ="com.squareup.okhttp3:mockwebserver:4.9.1"
}

object AndroidTestLibraries {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0"
    const val junit = "junit:junit:4.+"
    const val coreTesting ="androidx.arch.core:core-testing:2.1.0"
    const val testExt = "androidx.test.ext:junit:1.1.3"
    const val truth = "com.google.truth:truth:1.0.1"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    const val rules = "com.android.support.test:rules:1.0.2"
    const val hilt = "com.google.dagger:hilt-android-testing"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler"
    const val fragmentTesting = "androidx.fragment:fragment-testing:1.4.1"
}