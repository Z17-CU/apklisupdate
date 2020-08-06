package cu.uci.apklisupdate.view;

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import cu.uci.apklisupdate.R
import cu.uci.apklisupdate.model.AppUpdateInfo
import kotlinx.android.synthetic.main.fragment_update.*

class UpdateFragment : Fragment() {

    fun layout(): Int = R.layout.fragment_update

    lateinit var updateInfo: AppUpdateInfo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout(), container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changelog.setHtml("${context?.getString(R.string.changelog)}\n${updateInfo.last_release.changelog}")
        version.text = updateInfo.last_release.changelog

        fromApklis.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data =
                Uri.parse("https://www.apklis.cu/application/${updateInfo.package_name}")
            requireContext().startActivity(Intent.createChooser(i, ""))
        }

        download.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(updateInfo.last_release.apk_file)
            requireContext().startActivity(Intent.createChooser(i, ""))
        }
    }


    private var background: Int = 0

    private var actionsColor: Int = 0

    companion object {

        fun newInstance(updateInfo: AppUpdateInfo, @DrawableRes background: Int = android.R.color.white, @ColorRes actionsColor: Int = android.R.color.black): UpdateFragment {
            return UpdateFragment().apply {
                this.updateInfo = updateInfo
                this.background = background
                this.actionsColor = actionsColor
            }
        }
    }

}