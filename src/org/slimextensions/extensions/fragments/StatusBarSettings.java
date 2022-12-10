package org.slimextensions.extensions.fragments;

import android.os.Bundle;
import com.android.settings.SettingsPreferenceFragment;
import org.slimextensions.extensions.R$xml;

/* loaded from: classes2.dex */
public class StatusBarSettings extends SettingsPreferenceFragment {
    @Override // com.android.settingslib.core.instrumentation.Instrumentable
    public int getMetricsCategory() {
        return 1999;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R$xml.slim_settings_statusbar);
    }
}
