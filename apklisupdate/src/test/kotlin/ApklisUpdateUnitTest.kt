import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import cu.uci.apklisupdate.ApklisUpdate
import cu.uci.apklisupdate.UpdateCallback
import cu.uci.apklisupdate.model.AppUpdateInfo
import org.amshove.kluent.mock
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

import org.junit.Assert.*
import java.lang.Exception

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ApklisUpdateUnitTest {

    var mMockContext: Context = mock(Context::class)

    var mMockPM: PackageManager = mock(PackageManager::class)

    var mMockPI: PackageInfo = mock(PackageInfo::class)

    @Test
    fun hasUpdate_isCorrect() {
        Mockito.`when`(mMockContext.packageName).thenReturn(PACKAGE)
        Mockito.`when`(mMockContext.packageManager).thenReturn(mMockPM)
        Mockito.`when`(mMockPM.getPackageInfo(PACKAGE, 0)).thenReturn(mMockPI)
        Mockito.`when`(mMockPI.longVersionCode).thenReturn(0L)
        mMockPI.versionCode = 0
        mMockPI.versionName = "test"

        ApklisUpdate.hasAppUpdate(mMockContext, object : UpdateCallback {
            override fun onNewUpdate(appUpdateInfo: AppUpdateInfo) {

                assertTrue(appUpdateInfo.last_release.version_code > 0)
            }

            override fun onOldUpdate(appUpdateInfo: AppUpdateInfo) {
                assertTrue(appUpdateInfo.last_release.version_code == 0)

            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }

    companion object {

        private val PACKAGE = "cu.uci.android.apklis"
    }
}