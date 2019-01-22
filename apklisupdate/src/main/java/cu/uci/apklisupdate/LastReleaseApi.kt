package cu.uci.apklisupdate

import cu.uci.apklisupdate.model.AppUpdateInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Adrian Arencibia Herrera on 5/29/18.
 * Email: adrian011494@gmail.com
 */
interface LastReleaseApi {
    @GET("api/v1/application/{package}/")
    fun lastRelease(@Path("package") appPackage: String): Single<AppUpdateInfo>

}