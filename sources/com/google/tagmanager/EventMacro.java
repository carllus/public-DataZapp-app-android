package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;

class EventMacro extends FunctionCallImplementation {

    /* renamed from: ID */
    private static final String f702ID = FunctionType.EVENT.toString();
    private final Runtime mRuntime;

    public static String getFunctionId() {
        return f702ID;
    }

    public EventMacro(Runtime runtime) {
        super(f702ID, new String[0]);
        this.mRuntime = runtime;
    }

    public boolean isCacheable() {
        return false;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> map) {
        String currentEventName = this.mRuntime.getCurrentEventName();
        return currentEventName == null ? Types.getDefaultValue() : Types.objectToValue(currentEventName);
    }
}
