package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExpectedResultFromPropertyFile {
	private static Properties properties;
	
	static {
		properties = new Properties();
		try(FileInputStream input = new FileInputStream("src/test/java/properties/expectedResults.properties")){
			properties.load(input);
		} 
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return properties.getProperty(key);
	}

}
