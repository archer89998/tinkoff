package ru.tinkoff.structure.common.ApiClient;

import com.google.gson.Gson;

public class JsonUtil {

    private JsonUtil(){

    }

    public static <T> T parseJson(final String json, final Class <T> returnType){
        final Gson gson = new Gson();
        return gson.fromJson(json,returnType);
    }
}
