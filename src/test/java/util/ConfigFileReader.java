package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by raghavendra on 25/04/18.
 */
public class ConfigFileReader {

    // move this to WebUtil
    public static String getProperty(String key) throws IOException {
        
        String propertyFilePath = "/home/developer/projects/hotel-booking/src/test/resources/configs/Configuration.properties";
        BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
        Properties properties = new Properties();
        properties.load(reader);
        return  properties.getProperty(key);

    }
}
