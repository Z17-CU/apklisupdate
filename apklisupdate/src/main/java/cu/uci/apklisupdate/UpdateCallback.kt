package cu.uci.apklisupdate

import cu.uci.apklisupdate.model.AppUpdateInfo

interface UpdateCallback {
    fun onNewUpdate(appUpdateInfo: AppUpdateInfo)
    fun onOldUpdate(appUpdateInfo: AppUpdateInfo)
    fun onError(e: Throwable)
}
