package cu.uci.apklisupdate.view;

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import cu.uci.apklisupdate.R
import cu.uci.apklisupdate.model.AppUpdateInfo
import kotlinx.android.synthetic.main.apklis_fragment_update.*

class ApklisUpdateFragment : Fragment() {

    fun layout(): Int = R.layout.apklis_fragment_update

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
        version.text = updateInfo.last_release.version_name
        title.text = updateInfo.name
        fromApklis.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data =
                Uri.parse("https://www.apklis.cu/application/${updateInfo.package_name}")
            requireContext().startActivity(Intent.createChooser(i, getString(R.string.open_web)))
        }

        download.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(updateInfo.last_release.apk_file)
            requireContext().startActivity(Intent.createChooser(i, getString(R.string.download)))
        }

        Picasso.get().load(updateInfo.last_release.icon).into(logo)

        getView()?.setBackgroundDrawable(background)


        fromApklis.setTextColor(actionsColor)
        download.setTextColor(actionsColor)
    }


    private var background: Drawable = ColorDrawable(Color.WHITE)

    private var actionsColor: Int = 0

    companion object {

        fun newInstance(
            updateInfo: AppUpdateInfo,
            background: Drawable = ColorDrawable(Color.WHITE),
            @ColorInt actionsColor: Int = Color.BLACK
        ): ApklisUpdateFragment {
            return ApklisUpdateFragment().apply {
                this.updateInfo = updateInfo
                this.background = background
                this.actionsColor = actionsColor
            }
        }
    }

}