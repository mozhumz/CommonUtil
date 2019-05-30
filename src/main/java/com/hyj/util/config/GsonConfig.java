package com.hyj.util.config;

import com.google.gson.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GsonConfig implements JsonSerializer, JsonDeserializer {

    private static final Log logger = LogFactory.getLog(GsonConfig.class);


    public Date deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(arg0.getAsJsonPrimitive().getAsString());
        } catch (ParseException e) {
            logger.error("UtilDateGSON deserialize error.", e);
        }

        return date;
    }


    public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new JsonPrimitive(sdf.format(o));
    }
}
