# Check app update in [Apklis](https://www.apklis.cu/es/)
[![](https://jitpack.io/v/adrian011494/apklisupdate.svg)](https://jitpack.io/#adrian011494/apklisupdate)

### Installing
* Step 1. Add the JitPack repository to your build file
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
* Step 2. Add the dependency
```groovy
implementation 'com.github.adrian011494:apklisupdate:$VERSION'	
```
### Usage

* Check current app
```kotlin
 ApklisUpdate.hasAppUpdate(this, callback = object : UpdateCallback {

            override fun onNewUpdate(appUpdateInfo: AppUpdateInfo) {

                //Start info fragment or do what you want.
                supportFragmentManager.beginTransaction().add(
                    R.id.container, ApklisUpdateFragment.newInstance(
                        updateInfo = appUpdateInfo,
                        actionsColor = ContextCompat.getColor(this@MainActivity, R.color.colorAccent)
                    )
                ).commit()

            }

            override fun onOldUpdate(appUpdateInfo: AppUpdateInfo) {
                Log.d("MainActivity", "onOldUpdate $appUpdateInfo")
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
```
* Check external app
```kotlin
ApklisUpdate.hasAppUpdate("APP_PACKAGE_NAME", callback = object : UpdateCallback {...})
```
### Contributing
All contributions are welcome!!!