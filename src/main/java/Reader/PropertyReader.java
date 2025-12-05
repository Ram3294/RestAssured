package Reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String getProperty(String keyName) throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\Pratik Gadekar\\git\\RestAssured\\src\\main\\java\\ConfigurationLayer\\Config.properties");
		Properties prop=new Properties();
		prop.load(f);
		prop.getProperty(keyName);
		
		return prop.getProperty(keyName);
		
	}
}
