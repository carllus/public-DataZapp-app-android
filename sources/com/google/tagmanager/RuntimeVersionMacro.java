package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;

class RuntimeVersionMacro extends FunctionCallImplementation {

    /* renamed from: ID */
    private static final String f719ID = FunctionType.RUNTIME_VERSION.toString();
    public static final long VERSION_NUMBER = 62676326;

    public static String getFunctionId() {
        return f719ID;
    }

    public RuntimeVersionMacro() {
        super(f719ID, new String[0]);
    }

    public boolean isCacheable() {
        return true;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> map) {
        return Types.objectToValue(Long.valueOf(VERSION_NUMBER));
    }
}
