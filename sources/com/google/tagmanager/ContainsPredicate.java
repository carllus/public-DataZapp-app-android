package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;

class ContainsPredicate extends StringPredicate {

    /* renamed from: ID */
    private static final String f693ID = FunctionType.CONTAINS.toString();

    public static String getFunctionId() {
        return f693ID;
    }

    public ContainsPredicate() {
        super(f693ID);
    }

    /* access modifiers changed from: protected */
    public boolean evaluateString(String arg0, String arg1, Map<String, TypeSystem.Value> map) {
        return arg0.contains(arg1);
    }
}
