package com.vanced.manager.ui.widget.settings

import androidx.compose.runtime.Composable
import com.vanced.manager.R
import com.vanced.manager.ui.component.preference.Preference
import com.vanced.manager.ui.resources.managerString

@Composable
fun SettingsClearFilesItem() {
    Preference(
        preferenceTitle = managerString(
            stringId = R.string.settings_preference_clear_files_title
        ),
        preferenceDescription = null,
        onClick = {}
    )
}