package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;

class StartsWithPredicate extends StringPredicate {

    /* renamed from: ID */
    private static final String f721ID = FunctionType.STARTS_WITH.toString();

    public static String getFunctionId() {
        return f721ID;
    }

    public StartsWithPredicate() {
        super(f721ID);
    }

    /* access modifiers changed from: protected */
    public boolean evaluateString(String arg0, String arg1, Map<String, TypeSystem.Value> map) {
        return arg0.startsWith(arg1);
    }
}
