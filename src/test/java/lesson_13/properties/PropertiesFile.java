package lesson_13.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
    static Properties properties = new Properties();

    public static void main(String[] args) {
        readPropertiesFile();
        writePropertiesFile();
        readPropertiesFile();
    }
    public static void readPropertiesFile(){
        try {
            InputStream inputStream = new FileInputStream("C:\\Users\\barisa\\IdeaProjects\\Lesson_2_Methods\\src\\test\\java\\Lesson_13\\properties\\config.properties");
            properties.load(inputStream);
            System.out.println(properties.getProperty("Username"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void writePropertiesFile(){
        try {
            OutputStream outputStream = new FileOutputStream("C:\\Users\\barisa\\IdeaProjects\\Lesson_2_Methods\\src\\test\\java\\Lesson_13\\properties\\config.properties");
            properties.setProperty("Username","Ahmet");
            properties.setProperty("result","pass");
            properties.setProperty("Address","Istanbul,Pendik");
            properties.store(outputStream,null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
