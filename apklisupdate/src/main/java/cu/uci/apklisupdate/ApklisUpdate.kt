package cu.uci.apklisupdate

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object ApklisUpdate {

    @SuppressLint("CheckResult")
    fun hasAppUpdate(context: Context, callback: UpdateCallback) {

        LastReleaseClient.instance()
            .lastRelease(context.packageName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({

                val manager = context.packageManager
                val info = manager.getPackageInfo(
                    context.packageName, 0
                )

                val versionCode: Long = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    info.longVersionCode
                } else {
                    info.versionCode.toLong()
                }

                if (it != null) {
                    if (versionCode < it.last_release.version_code)
                        callback.onNewUpdate(it)
                    else
                        callback.onOldUpdate(it)
                } else
                    callback.onError(Exception("Not data"))
            }, {
                it.printStackTrace()
                callback.onError(it)
            })

    }

    @SuppressLint("CheckResult")
    fun hasAppUpdate(packageName: String, versionCode: Long = 0, callback: UpdateCallback) {

        LastReleaseClient.instance()
            .lastRelease(packageName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({

                if (it != null) {
                    if (versionCode < it.last_release.version_code)
                        callback.onNewUpdate(it)
                    else
                        callback.onOldUpdate(it)
                } else
                    callback.onError(Exception("Not data"))
            }, {
                it.printStackTrace()
                callback.onError(it)
            })

    }
}