package cu.uci.apklisupdate.view

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso
import cu.uci.apklisupdate.R
import cu.uci.apklisupdate.model.AppUpdateInfo
import kotlinx.android.synthetic.main.apklis_dialog_update.*
import org.sufficientlysecure.htmltextview.HtmlTextView

class ApklisUpdateDialog(
    context: Context,
    private val updateInfo: AppUpdateInfo,
    @ColorInt private var actionsColor: Int = 0
) : AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apklis_dialog_update)

        changelog.setHtml("${context.getString(R.string.changelog)}\n${updateInfo.last_release.changelog}")
        version.text = updateInfo.last_release.version_name
        title.text = updateInfo.name
        fromApklis.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data =
                Uri.parse("https://www.apklis.cu/es/application/${updateInfo.package_name}/latest")
            context.startActivity(Intent.createChooser(i, context.getString(R.string.open_web)))
        }

        download.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(updateInfo.last_release.apk_file)
            context.startActivity(Intent.createChooser(i, context.getString(R.string.download)))
        }

        Picasso.get().load(updateInfo.last_release.icon).into(logo)

        fromApklis.setTextColor(actionsColor)
        download.setTextColor(actionsColor)
    }

}