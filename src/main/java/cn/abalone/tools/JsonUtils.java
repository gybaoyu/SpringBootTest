package cn.abalone.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    public static String convertToJson(Object object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}