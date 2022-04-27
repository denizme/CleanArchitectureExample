
buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Paths.gradleClasspath)
        classpath(Paths.kotlinGradlePluginClasspath)
        classpath(Paths.hiltGradlePluginClasspath)
        classpath(Paths.navigationGradlePluginClasspath)
    }
}

tasks.register("type",Delete::class){
    delete(rootProject.buildDir)
}