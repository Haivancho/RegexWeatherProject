package com.jboxers.regexParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class ReadProperty {

    public static String readProperty(String propertyName) {
        try (InputStream input = ReadProperty.class.getClassLoader().getResourceAsStream("config.properties");
             InputStreamReader isr = new InputStreamReader(input, Charset.forName("UTF-8"))) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(isr);

            // get the property value and print it out
            return  prop.getProperty(propertyName);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
