plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "cu.uci.ejemploapklis"
    compileSdk = 34

    defaultConfig {
        applicationId = "cu.uci.ejemploapklis"
        minSdk = 15
        targetSdk = 34
        multiDexEnabled = true
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        missingDimensionStrategy("version", "full", "non-view")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.core)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    implementation(libs.palette)
    implementation(project(":apklisupdate"))
}
