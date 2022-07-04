package generalUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    public Properties properties=null;
    public PropertiesHelper(String filePath){
        FileInputStream in= null;
        try {
            in = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        properties=new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        public static synchronized Properties getBaseConfig() {
            Properties properties=null;
                 if (properties == null) {
                    FileInputStream in;
                    try {
                        in = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//generalConfig//configFile.properties");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    properties = new Properties();
                    try {
                        properties.load(in);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
return properties;
        }





}
