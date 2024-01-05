pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url = uri("https://jitpack.io") }

        google()
        mavenCentral()
        jcenter()
        maven { url = uri("https://maven.aliyun.com/repository/google")}
        maven { url = uri("https://maven.aliyun.com/repository/central")}
        maven { url = uri("https://maven.aliyun.com/repository/jcenter")}
    }
}

include(":app", ":apklisupdate")
