package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Locale;
import java.util.Map;

class LanguageMacro extends FunctionCallImplementation {

    /* renamed from: ID */
    private static final String f709ID = FunctionType.LANGUAGE.toString();

    public static String getFunctionId() {
        return f709ID;
    }

    public LanguageMacro() {
        super(f709ID, new String[0]);
    }

    public boolean isCacheable() {
        return false;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return Types.getDefaultValue();
        }
        String language = locale.getLanguage();
        if (language == null) {
            return Types.getDefaultValue();
        }
        return Types.objectToValue(language.toLowerCase());
    }
}
