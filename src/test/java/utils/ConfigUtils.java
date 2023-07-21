package utils;

import java.util.Properties;

public class ConfigUtils {

    private final Properties properties;

    private  static ConfigUtils configUtils;

    private ConfigUtils(){
        properties=PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties");

    }

    public static ConfigUtils getInstance(){
        if(configUtils == null) {
          configUtils = new ConfigUtils();
         }
        return configUtils;
    }


    public  String getBaseUrl(){
       String url =properties.getProperty("baseUrl");
          if(url !=null && !url.equals(""))  return url;
       throw new RuntimeException("Couldn't find the base url in property file ");
    }

    public String getEmail(){
        String email= properties.getProperty("email");
            if(email != null && !email.equals("")) return email;
        throw new RuntimeException("Couldn't find the email in property file ");
    }

    public String getPassword(){
        String password = properties.getProperty("password");
            if(password != null && !password.equals("")) return password;
        throw new RuntimeException("Couldn't find the password in property file ");
    }
}
