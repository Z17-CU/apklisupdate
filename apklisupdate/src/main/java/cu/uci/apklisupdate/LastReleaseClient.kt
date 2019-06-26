package cu.uci.apklisupdate

import cu.uci.apklisupdate.base.RestClient
import cu.uci.apklisupdate.model.AppUpdateInfo
import io.reactivex.Single

/**
 * Created by Adrian Arencibia Herrera on 5/29/18.
 * Email: adrian011494@gmail.com
 */

class LastReleaseClient : RestClient<LastReleaseApi>(LastReleaseApi::class.java) {

    fun lastRelease(appPackage: String): Single<AppUpdateInfo?> {
        return mApi.lastRelease(appPackage)
            .map {
                it.results.firstOrNull()
            }
    }

    companion object {
        fun instance() = LastReleaseClient()
    }
}