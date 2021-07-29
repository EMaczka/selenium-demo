package demo.testrun;

import demo.testrun.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    static Properties properties = new Properties();

    public static void readPropertiesFile() throws IOException {

        InputStream inputStream = new FileInputStream("../common-utils/src/main/resources/config.properties");
        properties.load(inputStream);
        String browser = properties.getProperty("browser");
        TestBase.browser=browser;
    }
}
