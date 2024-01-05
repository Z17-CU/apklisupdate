// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.gradle)
    }
}

plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
