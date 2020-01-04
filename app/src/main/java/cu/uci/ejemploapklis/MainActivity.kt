package cu.uci.ejemploapklis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import cu.uci.apklisupdate.ApklisUpdate
import cu.uci.apklisupdate.UpdateCallback
import cu.uci.apklisupdate.model.AppUpdateInfo
import cu.uci.apklisupdate.view.ApklisUpdateFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ApklisUpdate.hasAppUpdate("cu.uci.android.apklis", callback = object : UpdateCallback {

            override fun onNewUpdate(appUpdateInfo: AppUpdateInfo) {

                //Start info alert dialog or do what you want.
                ApklisUpdateDialog(
                    this@MainActivity,
                    appUpdateInfo,
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.colorAccent)
                ).show()

                //Start info fragment or do what you want.
                //supportFragmentManager.beginTransaction().add(
                //    R.id.container, ApklisUpdateFragment.newInstance(
                //        updateInfo = appUpdateInfo,
                //        actionsColor = ContextCompat.getColor(this@MainActivity, R.color.colorAccent)
                //    )
                //).commit()

            }

            override fun onOldUpdate(appUpdateInfo: AppUpdateInfo) {
                Log.d("MainActivity", "onOldUpdate $appUpdateInfo")
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }
}
