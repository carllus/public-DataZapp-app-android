package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;

class TimeMacro extends FunctionCallImplementation {

    /* renamed from: ID */
    private static final String f722ID = FunctionType.TIME.toString();

    public static String getFunctionId() {
        return f722ID;
    }

    public TimeMacro() {
        super(f722ID, new String[0]);
    }

    public boolean isCacheable() {
        return false;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> map) {
        return Types.objectToValue(Long.valueOf(System.currentTimeMillis()));
    }
}
