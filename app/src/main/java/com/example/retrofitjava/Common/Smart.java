package com.example.retrofitjava.Common;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Smart {
    public static Gson GetGSON() {
        try {
            ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                    return false;
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return clazz == Field.class || clazz == Method.class;
                }
            };

            return new GsonBuilder()
                    .addSerializationExclusionStrategy(exclusionStrategy)
                    .addDeserializationExclusionStrategy(exclusionStrategy)
                    .create();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Gson();
    }
}
