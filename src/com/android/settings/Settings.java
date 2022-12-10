package com.android.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.FeatureFlagUtils;
import android.util.Log;
import com.android.internal.annotations.VisibleForTesting;
import com.android.settings.enterprise.EnterprisePrivacySettings;
import com.android.settings.network.MobileNetworkIntentConverter;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.safetycenter.SafetyCenterManagerWrapper;
import com.android.settings.security.SecuritySettingsFeatureProvider;
import com.google.android.setupdesign.util.ThemeHelper;

/* loaded from: classes.dex */
public class Settings extends SettingsActivity {

    /* loaded from: classes.dex */
    public static class AccessibilityDaltonizerSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AccessibilityDetailsSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AccessibilityInversionSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AccessibilitySettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AccountDashboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AccountSyncSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AdaptiveBrightnessActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AdvancedConnectedDeviceActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AlarmsAndRemindersActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AlarmsAndRemindersAppActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AndroidBeamSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ApnEditorActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ApnSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppBubbleNotificationSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppDashboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppDrawOverlaySettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppInteractAcrossProfilesSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppManageExternalStorageActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppMediaManagementAppsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppMemoryUsageActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppNotificationSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppPictureInPictureSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppUsageAccessSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AppWriteSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AssistGestureSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AutomaticStorageManagerSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class AvailableVirtualKeyboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class BatterySaverScheduleSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class BatterySaverSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class BlueToothPairingActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class BluetoothBroadcastActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class BluetoothDeviceDetailActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class BluetoothFindBroadcastsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class BluetoothSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class BugReportHandlerPickerActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ButtonNavigationSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class CaptioningSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ChangeWifiStateActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ChooseAccountActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class CombinedBiometricProfileSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class CombinedBiometricSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ConfigureNotificationSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ConfigureWifiSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ConnectedDeviceDashboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ConversationListSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class CreateShortcutActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DarkThemeSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DataSaverSummaryActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DataUsageSummaryActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DateTimeSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DevRunningServicesActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DevelopmentSettingsDashboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DeviceAdminSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DisplaySettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class DreamSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ExtensionsSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class FaceSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class FaceSettingsInternalActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class FingerprintSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class GamesStorageActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class GestureNavigationSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class HighPowerApplicationsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class IccLockSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class InteractAcrossProfilesSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class KeyboardLayoutPickerActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class LanguageAndInputSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class LocalePickerActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class LocationSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class LockScreenSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ManageAppExternalSourcesActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ManageApplicationsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ManageAssistActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ManageDomainUrlsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ManageExternalSourcesActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ManageExternalStorageActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ManagedProfileSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class MediaControlsSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class MediaManagementAppsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class MobileDataUsageListActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class MobileNetworkListActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ModuleLicensesActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class MyDeviceInfoActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NetworkDashboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NetworkProviderSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NetworkSelectActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NightDisplaySettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NightDisplaySuggestionActivity extends NightDisplaySettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NotificationAccessDetailsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NotificationAccessSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NotificationAppListActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NotificationAssistantSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NotificationReviewPermissionsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class NotificationStationActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class OneHandedSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class OverlaySettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PaymentSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PhysicalKeyboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PictureInPictureSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PowerMenuSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PowerUsageSummaryActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PremiumSmsAccessActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PrintJobSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PrintSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PrivacyControlsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PrivacySettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PrivateVolumeForgetActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class PublicVolumeSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ReduceBrightColorsSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class RunningServicesActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class SavedAccessPointsSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ScanningSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class SecurityAdvancedSettings extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class SmartAutoRotateSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class SoundSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class SpellCheckersSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class StorageDashboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class StorageUseActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class SystemDashboardActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class TestingSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class TextToSpeechSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class TrustedCredentialsSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class TurnScreenOnSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class UsageAccessSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class UsbDetailsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class UserDictionarySettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class UserSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class VpnSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class VrListenersSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WallpaperSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WebViewAppPickerActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiAPITestActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiCallingDisclaimerActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiCallingSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiDetailsSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiDisplaySettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiInfoActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiP2pSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiScanningSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WifiSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class WriteSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ZenAccessDetailSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ZenAccessSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ZenModeAutomationSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ZenModeEventRuleSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ZenModeScheduleRuleSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class ZenModeSettingsActivity extends SettingsActivity {
    }

    /* loaded from: classes.dex */
    public static class TetherSettingsActivity extends SettingsActivity {
        @Override // com.android.settings.SettingsActivity, android.app.Activity
        public Intent getIntent() {
            return Settings.wrapIntentWithAllInOneTetherSettingsIfNeeded(getApplicationContext(), super.getIntent());
        }
    }

    /* loaded from: classes.dex */
    public static class WifiTetherSettingsActivity extends SettingsActivity {
        @Override // com.android.settings.SettingsActivity, android.app.Activity
        public Intent getIntent() {
            return Settings.wrapIntentWithAllInOneTetherSettingsIfNeeded(getApplicationContext(), super.getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent wrapIntentWithAllInOneTetherSettingsIfNeeded(Context context, Intent intent) {
        Bundle bundle;
        if (FeatureFlagUtils.isEnabled(context, "settings_tether_all_in_one")) {
            Intent intent2 = new Intent(intent);
            intent2.putExtra(":settings:show_fragment", AllInOneTetherSettings.class.getCanonicalName());
            Bundle bundleExtra = intent.getBundleExtra(":settings:show_fragment_args");
            if (bundleExtra != null) {
                bundle = new Bundle(bundleExtra);
            } else {
                bundle = new Bundle();
            }
            bundle.putParcelable("intent", intent);
            intent2.putExtra(":settings:show_fragment_args", bundle);
            return intent2;
        }
        return intent;
    }

    /* loaded from: classes.dex */
    public static class SecurityDashboardActivity extends SettingsActivity {
        @Override // com.android.settings.SettingsActivity, com.android.settings.core.SettingsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            handleSafetyCenterRedirection();
        }

        @VisibleForTesting
        public void handleSafetyCenterRedirection() {
            if (SafetyCenterManagerWrapper.get().isEnabled(this)) {
                try {
                    startActivity(new Intent("android.intent.action.SAFETY_CENTER"));
                    finish();
                } catch (ActivityNotFoundException e) {
                    Log.e("SecurityDashboardActivity", "Unable to open safety center", e);
                }
            }
        }

        @Override // com.android.settings.SettingsActivity
        @VisibleForTesting
        public boolean isValidFragment(String str) {
            return super.isValidFragment(str) || (str != null && TextUtils.equals(str, getAlternativeFragmentName()));
        }

        @Override // com.android.settings.SettingsActivity
        public String getInitialFragmentName(Intent intent) {
            String alternativeFragmentName = getAlternativeFragmentName();
            return alternativeFragmentName != null ? alternativeFragmentName : super.getInitialFragmentName(intent);
        }

        private String getAlternativeFragmentName() {
            SecuritySettingsFeatureProvider securitySettingsFeatureProvider = FeatureFactory.getFactory(this).getSecuritySettingsFeatureProvider();
            if (securitySettingsFeatureProvider.hasAlternativeSecuritySettingsFragment()) {
                return securitySettingsFeatureProvider.getAlternativeSecuritySettingsFragmentClassname();
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class PrivacyDashboardActivity extends SettingsActivity {
        @Override // com.android.settings.SettingsActivity, com.android.settings.core.SettingsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            handleSafetyCenterRedirection();
        }

        @VisibleForTesting
        public void handleSafetyCenterRedirection() {
            if ("android.settings.PRIVACY_SETTINGS".equals(getIntent().getAction()) && SafetyCenterManagerWrapper.get().isEnabled(this)) {
                try {
                    startActivity(new Intent("android.intent.action.SAFETY_CENTER"));
                    finish();
                } catch (ActivityNotFoundException e) {
                    Log.e("PrivacyDashboardActivity", "Unable to open safety center", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FactoryResetActivity extends SettingsActivity {
        @Override // com.android.settings.core.SettingsBaseActivity
        protected boolean isToolbarEnabled() {
            return false;
        }

        @Override // com.android.settings.SettingsActivity, com.android.settings.core.SettingsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        protected void onCreate(Bundle bundle) {
            setTheme(SetupWizardUtils.getTheme(this, getIntent()));
            ThemeHelper.trySetDynamicColor(this);
            super.onCreate(bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class FactoryResetConfirmActivity extends SettingsActivity {
        @Override // com.android.settings.core.SettingsBaseActivity
        protected boolean isToolbarEnabled() {
            return false;
        }

        @Override // com.android.settings.SettingsActivity, com.android.settings.core.SettingsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        protected void onCreate(Bundle bundle) {
            setTheme(SetupWizardUtils.getTheme(this, getIntent()));
            ThemeHelper.trySetDynamicColor(this);
            super.onCreate(bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class EnterprisePrivacySettingsActivity extends SettingsActivity {
        @Override // com.android.settings.SettingsActivity, com.android.settings.core.SettingsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (FeatureFactory.getFactory(this).getEnterprisePrivacyFeatureProvider(this).showParentalControls()) {
                finish();
            } else if (EnterprisePrivacySettings.isPageEnabled(this)) {
            } else {
                finish();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MobileNetworkActivity extends SettingsActivity {
        private MobileNetworkIntentConverter mIntentConverter;

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        protected void onNewIntent(Intent intent) {
            super.onNewIntent(intent);
            Log.d("MobileNetworkActivity", "Starting onNewIntent");
            createUiFromIntent(null, convertIntent(intent));
        }

        @Override // com.android.settings.SettingsActivity, android.app.Activity
        public Intent getIntent() {
            return convertIntent(super.getIntent());
        }

        private Intent convertIntent(Intent intent) {
            if (this.mIntentConverter == null) {
                this.mIntentConverter = new MobileNetworkIntentConverter(this);
            }
            Intent apply = this.mIntentConverter.apply(intent);
            return apply == null ? intent : apply;
        }

        public static boolean doesIntentContainOptInAction(Intent intent) {
            return TextUtils.equals(intent != null ? intent.getAction() : null, "android.telephony.ims.action.SHOW_CAPABILITY_DISCOVERY_OPT_IN");
        }
    }
}
