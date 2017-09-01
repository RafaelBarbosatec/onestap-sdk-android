package com.onestap.core.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.customtabs.CustomTabsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 31/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class CustomTabsHelper {

    private static final String TAG = "CustomTabLauncher";
    static final String STABLE_PACKAGE = "com.android.chrome";
    static final String BETA_PACKAGE = "com.chrome.beta";
    static final String DEV_PACKAGE = "com.chrome.dev";
    static final String LOCAL_PACKAGE = "com.google.android.apps.chrome";
    private static String mPackageNameToUse;



    public static String getPackageNameToUse(Context context) {
        if (mPackageNameToUse != null) {
            return mPackageNameToUse;
        }

        // Get default VIEW intent handler that can view a web url.
        Intent activityIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.onestap.com"));

        // Get all apps that can handle VIEW intents.
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolvedActivityList = pm.queryIntentActivities(activityIntent, 0);
        List<String> packagesSupportingCustomTabs = new ArrayList<>();
        for (ResolveInfo info : resolvedActivityList) {
            Intent serviceIntent = new Intent();
            serviceIntent.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            serviceIntent.setPackage(info.activityInfo.packageName);
            if (pm.resolveService(serviceIntent, 0) != null) {
                packagesSupportingCustomTabs.add(info.activityInfo.packageName);
            }
        }

        // Now packagesSupportingCustomTabs contains all apps that can handle both VIEW intents
        // and service calls.
        if (packagesSupportingCustomTabs.isEmpty()) {
            mPackageNameToUse = null;
        } else if (packagesSupportingCustomTabs.size() == 1) {
            mPackageNameToUse = packagesSupportingCustomTabs.get(0);
        } else if (packagesSupportingCustomTabs.contains(STABLE_PACKAGE)) {
            mPackageNameToUse = STABLE_PACKAGE;
        } else if (packagesSupportingCustomTabs.contains(BETA_PACKAGE)) {
            mPackageNameToUse = BETA_PACKAGE;
        } else if (packagesSupportingCustomTabs.contains(DEV_PACKAGE)) {
            mPackageNameToUse = DEV_PACKAGE;
        } else if (packagesSupportingCustomTabs.contains(LOCAL_PACKAGE)) {
            mPackageNameToUse = LOCAL_PACKAGE;
        }
        return mPackageNameToUse;
    }

}
