/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.language;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.provider.Settings;
import android.speech.RecognitionService;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Helper class of the Voice Input setting. */
public final class VoiceInputHelper {
    static final String TAG = "VoiceInputHelper";
    final Context mContext;

    final List<ResolveInfo> mAvailableRecognition;

    /**
     * Base info of the Voice Input provider.
     *
     * TODO: Remove this superclass as we only have 1 class now (RecognizerInfo).
     */
    public static class BaseInfo implements Comparable<BaseInfo> {
        public final ServiceInfo mService;
        public final ComponentName mComponentName;
        public final String mKey;
        public final ComponentName mSettings;
        public final CharSequence mLabel;
        public final String mLabelStr;
        public final CharSequence mAppLabel;

        public BaseInfo(PackageManager pm, ServiceInfo service, String settings) {
            mService = service;
            mComponentName = new ComponentName(service.packageName, service.name);
            mKey = mComponentName.flattenToShortString();
            mSettings = settings != null
                    ? new ComponentName(service.packageName, settings) : null;
            mLabel = service.loadLabel(pm);
            mLabelStr = mLabel.toString();
            mAppLabel = service.applicationInfo.loadLabel(pm);
        }

        @Override
        public int compareTo(BaseInfo another) {
            return mLabelStr.compareTo(another.mLabelStr);
        }
    }

    /** Info of the speech recognizer (i.e. recognition service). */
    public static class RecognizerInfo extends BaseInfo {
        public final boolean mSelectableAsDefault;

        public RecognizerInfo(PackageManager pm,
                ServiceInfo serviceInfo,
                String settings,
                boolean selectableAsDefault) {
            super(pm, serviceInfo, settings);
            this.mSelectableAsDefault = selectableAsDefault;
        }
    }

    final ArrayList<RecognizerInfo> mAvailableRecognizerInfos = new ArrayList<>();

    ComponentName mCurrentRecognizer;

    public VoiceInputHelper(Context context) {
        mContext = context;

        mAvailableRecognition = mContext.getPackageManager().queryIntentServices(
                new Intent(RecognitionService.SERVICE_INTERFACE),
                PackageManager.GET_META_DATA);
    }

    /** Draws the UI of the Voice Input picker page. */
    public void buildUi() {
        // Get the currently selected recognizer from the secure setting.
        String currentSetting = Settings.Secure.getString(
                mContext.getContentResolver(), Settings.Secure.VOICE_RECOGNITION_SERVICE);
        if (currentSetting != null && !currentSetting.isEmpty()) {
            mCurrentRecognizer = ComponentName.unflattenFromString(currentSetting);
        } else {
            mCurrentRecognizer = null;
        }

        // Iterate through all the available recognizers and load up their info to show
        // in the preference.
        int size = mAvailableRecognition.size();
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = mAvailableRecognition.get(i);
            ComponentName comp = new ComponentName(resolveInfo.serviceInfo.packageName,
                    resolveInfo.serviceInfo.name);
            ServiceInfo si = resolveInfo.serviceInfo;
            String settingsActivity = null;
            // Always show in voice input settings unless specifically set to False.
            boolean selectableAsDefault = true;
            try (XmlResourceParser parser = si.loadXmlMetaData(mContext.getPackageManager(),
                    RecognitionService.SERVICE_META_DATA)) {
                if (parser == null) {
                    throw new XmlPullParserException("No " + RecognitionService.SERVICE_META_DATA
                            + " meta-data for " + si.packageName);
                }

                Resources res = mContext.getPackageManager().getResourcesForApplication(
                        si.applicationInfo);

                AttributeSet attrs = Xml.asAttributeSet(parser);

                int type;
                while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                        && type != XmlPullParser.START_TAG) {
                    // Intentionally do nothing.
                }

                String nodeName = parser.getName();
                if (!"recognition-service".equals(nodeName)) {
                    throw new XmlPullParserException(
                            "Meta-data does not start with recognition-service tag");
                }

                TypedArray array = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.RecognitionService);
                settingsActivity = array.getString(
                        com.android.internal.R.styleable.RecognitionService_settingsActivity);
                selectableAsDefault = array.getBoolean(
                        com.android.internal.R.styleable.RecognitionService_selectableAsDefault,
                        true);
                array.recycle();
            } catch (XmlPullParserException e) {
                Log.e(TAG, "error parsing recognition service meta-data", e);
            } catch (IOException e) {
                Log.e(TAG, "error parsing recognition service meta-data", e);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "error parsing recognition service meta-data", e);
            }
            // The current recognizer must always be shown in the settings, whatever its
            // selectableAsDefault value is.
            if (selectableAsDefault || comp.equals(mCurrentRecognizer)) {
                mAvailableRecognizerInfos.add(new RecognizerInfo(mContext.getPackageManager(),
                        resolveInfo.serviceInfo, settingsActivity, selectableAsDefault));
            }
        }
        Collections.sort(mAvailableRecognizerInfos);
    }
}
