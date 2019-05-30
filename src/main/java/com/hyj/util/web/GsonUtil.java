package com.hyj.util.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hyj.util.config.GsonConfig;

import java.util.Date;

public class GsonUtil {
    public static Gson gson = getGson();


    public static Gson getGson() {
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
//        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
//            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
//                    throws JsonParseException {
//                return new Date(json.getAsJsonPrimitive().getAsLong());
//            }
//        });
        //json转obj例子:SessionUser user= gson.fromJson(json,new TypeToken<SessionUser>(){}.getType());
        builder.registerTypeAdapter(Date.class, new GsonConfig()).setDateFormat("yyyy-MM-dd HH:mm:ss");
        return builder.create();
    }
}
