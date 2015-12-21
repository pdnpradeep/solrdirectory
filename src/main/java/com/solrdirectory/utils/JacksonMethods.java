package com.solrdirectory.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Pradeep.P on 22-11-2015.
 */
public class JacksonMethods {

    public static Map<String,Object> convertJSONStringTOMap(String jsonString){
        if(jsonString == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            Map<String,Object> map = (Map<String,Object>)mapper.readValue(jsonString, Map.class);
            return map;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Object convertJSONStringToObject(String jsonString, Class<T> aClass){
        if(jsonString == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            T obj = mapper.readValue(jsonString, aClass);
            return obj;
        } catch (JsonGenerationException e) {
            //log.error("Error while parsing JSON String : "+jsonString);
            e.printStackTrace();
        } catch (JsonMappingException e) {
           // log.error("Error while parsing JSON String : "+jsonString);
            e.printStackTrace();
        } catch (IOException e) {
            //log.error("IO Error while parsing JSON String : "+jsonString);
            e.printStackTrace();
        }
        return null;
    }

    public static String convertObjectTOJSONString(Object object){
        if(object == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
