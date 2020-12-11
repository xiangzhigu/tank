package com.mashibing.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertMgr {
    static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if(properties == null) return null;
        return properties.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertMgr.get("initTankCount"));
    }
}
