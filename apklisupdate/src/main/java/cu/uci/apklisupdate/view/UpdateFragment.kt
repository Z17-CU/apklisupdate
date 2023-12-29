package cu.uci.apklisupdate.view;

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import cu.uci.apklisupdate.R
import cu.uci.apklisupdate.databinding.FragmentUpdateBinding
import cu.uci.apklisupdate.model.AppUpdateInfo

class UpdateFragment : Fragment() {
    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!

    fun layout(): Int = R.layout.fragment_update

    lateinit var updateInfo: AppUpdateInfo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (updateInfo.last_release.apk_file == null)
            binding.download.visibility = View.GONE

        binding.changelog.setHtml("${context?.getString(R.string.changelog)}\n${updateInfo.last_release.changelog}")
        binding.version.text = updateInfo.last_release.changelog

        binding.fromApklis.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data =
                Uri.parse("https://www.apklis.cu/application/${updateInfo.package_name}")
            requireContext().startActivity(Intent.createChooser(i, ""))
        }

        binding.download.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(updateInfo.last_release.apk_file)
            requireContext().startActivity(Intent.createChooser(i, ""))
        }
    }


    private var background: Int = 0

    private var actionsColor: Int = 0

    companion object {

        fun newInstance(
            updateInfo: AppUpdateInfo,
            @DrawableRes background: Int = android.R.color.white,
            @ColorRes actionsColor: Int = android.R.color.black
        ): UpdateFragment {
            return UpdateFragment().apply {
                this.updateInfo = updateInfo
                this.background = background
                this.actionsColor = actionsColor
            }
        }
    }

}