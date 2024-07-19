package lesson_13.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ecozsert\\training\\training\\src\\test\\java\\lesson_13\\properties\\config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
            System.out.println(properties.getProperty("Username"));
            System.out.println(properties.getProperty("Password"));
            System.out.println(properties.getProperty("browser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
