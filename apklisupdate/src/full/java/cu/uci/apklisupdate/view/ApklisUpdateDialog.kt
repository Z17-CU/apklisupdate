package cu.uci.apklisupdate.view

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import com.squareup.picasso.Picasso
import cu.uci.apklisupdate.R
import cu.uci.apklisupdate.databinding.ApklisDialogUpdateBinding
import cu.uci.apklisupdate.model.AppUpdateInfo

class ApklisUpdateDialog(
    context: Context,
    private val updateInfo: AppUpdateInfo,
    @ColorInt private var actionsColor: Int = 0
) : AlertDialog(context) {
    lateinit var binding: ApklisDialogUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ApklisDialogUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (updateInfo.last_release.apk_file == null)
            binding.download.visibility = View.GONE

        binding.changelog.setHtml("${context.getString(R.string.changelog)}\n${updateInfo.last_release.changelog}")
        binding.version.text = updateInfo.last_release.version_name
        binding.title.text = updateInfo.name
        binding.fromApklis.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data =
                Uri.parse("https://www.apklis.cu/application/${updateInfo.package_name}")
            context.startActivity(Intent.createChooser(i, context.getString(R.string.open_web)))
        }

        binding.download.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(updateInfo.last_release.apk_file)
            context.startActivity(Intent.createChooser(i, context.getString(R.string.download)))
        }

        Picasso.get().load(updateInfo.last_release.icon).into(binding.logo)

        binding.fromApklis.setTextColor(actionsColor)
        binding.download.setTextColor(actionsColor)
    }

}