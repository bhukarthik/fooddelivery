package util;
import java.io.IOException;
import java.util.Properties;
public final class PropertiesUtil {
    private PropertiesUtil(){}

    private static final Properties PROPERTIES =new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try(java.io.InputStream stream = PropertiesUtil.class.getClassLoader().getResourceAsStream("db.properties")){
            PROPERTIES.load(stream);
        }
        catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }


}
