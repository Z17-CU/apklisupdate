package cu.uci.apklisupdate

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import io.reactivex.schedulers.Schedulers


object ApklisUpdate {

    @SuppressLint("CheckResult")
    fun hasAppUpdate(context: Context, callback: UpdateCallback) {

        LastReleaseClient.instance()
            .lastRelease(context.packageName)
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
                if (versionCode < it.last_release.version_code && info.versionName != it.last_release.version_name)
                    callback.onNewUpdate(it)
                else
                    callback.onOldUpdate(it)
            }, {
                it.printStackTrace()
                callback.onError(it)
            })

    }
}