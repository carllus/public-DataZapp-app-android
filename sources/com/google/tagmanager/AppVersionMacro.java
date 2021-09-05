package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;

class AppVersionMacro extends FunctionCallImplementation {

    /* renamed from: ID */
    private static final String f689ID = FunctionType.APP_VERSION.toString();
    private final Context mContext;

    public static String getFunctionId() {
        return f689ID;
    }

    public AppVersionMacro(Context context) {
        super(f689ID, new String[0]);
        this.mContext = context;
    }

    public boolean isCacheable() {
        return true;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> map) {
        try {
            return Types.objectToValue(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            Log.m542e("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return Types.getDefaultValue();
        }
    }
}
