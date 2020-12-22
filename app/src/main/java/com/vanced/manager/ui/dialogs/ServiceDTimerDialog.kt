package com.vanced.manager.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.edit
import com.vanced.manager.core.ui.base.BindingDialogFragment
import com.vanced.manager.databinding.DialogServicedTimerBinding
import com.vanced.manager.utils.Extensions.getDefaultPrefs
import com.vanced.manager.utils.Extensions.writeServiceDScript
import com.vanced.manager.utils.PackageHelper
import com.vanced.manager.utils.PackageHelper.getPackageDir
import com.vanced.manager.utils.PackageHelper.getPkgNameRoot
import java.io.IOException
import java.util.*

class ServiceDTimerDialog : BindingDialogFragment<DialogServicedTimerBinding>() {

    private val prefs by lazy { requireActivity().getDefaultPrefs() }

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): DialogServicedTimerBinding = DialogServicedTimerBinding.inflate(inflater, container, false)

    override fun otherSetups() {
        bindData()
    }

    private fun bindData() {
        with (binding) {
            servicedSlider.value = prefs.getInt("serviced_sleep_timer", 1).toFloat()
            servicedCancel.setOnClickListener {
                dismiss()
            }
            servicedSave.setOnClickListener {
                try {
                    arrayOf("vanced", "music").forEach { app ->
                        val apkFPath = "${PackageHelper.apkInstallPath}/${app.capitalize(Locale.ROOT)}/base.apk"
                        getPackageDir(requireActivity(), getPkgNameRoot(app))?.let { it1 -> requireActivity().writeServiceDScript(apkFPath, it1, app) }
                    }
                } catch (e: IOException) {
                    return@setOnClickListener
                }

                prefs.edit {
                    putInt("serviced_sleep_timer", servicedSlider.value.toInt())
                }
                dismiss()
            }
        }
    }

}