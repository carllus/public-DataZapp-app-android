package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;

class EndsWithPredicate extends StringPredicate {

    /* renamed from: ID */
    private static final String f700ID = FunctionType.ENDS_WITH.toString();

    public static String getFunctionId() {
        return f700ID;
    }

    public EndsWithPredicate() {
        super(f700ID);
    }

    /* access modifiers changed from: protected */
    public boolean evaluateString(String arg0, String arg1, Map<String, TypeSystem.Value> map) {
        return arg0.endsWith(arg1);
    }
}
