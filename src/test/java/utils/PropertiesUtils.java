package utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {


    public static Properties loadProperties(String filePath){
        Properties properties;

        try{
            File file = new File(filePath);
            InputStream inputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(inputStream);
        }catch (FileNotFoundException e){
            throw new RuntimeException("Oops, File does not found");
        }
        catch (IOException o){
            throw new RuntimeException("Oops, Error while loading the properties");
        }
        return properties;
    }
}
