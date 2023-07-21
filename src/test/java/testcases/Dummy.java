package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Dummy {

    public static void main(String[] args) {

        try {
            File file = new File("src/test/java/com/qacart/todo/config/production.properties");
            InputStream inputStream = new FileInputStream(file);

            Properties properties = new Properties();
            properties.load(inputStream);
            String url = properties.getProperty("baseUrl");
            String email = properties.getProperty("email");
            String pwd = properties.getProperty("password");

            System.out.println("base url: " + url + "\n" + "email: " + email + "\n" + "password: " + pwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}


