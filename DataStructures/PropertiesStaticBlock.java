package propertiesFilesFunctions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesStaticBlock {
	private static Properties prop=null;
	static{
		InputStream in=null;
		try{
			prop=new Properties();
			in=ClassLoader.class.getResourceAsStream("/sample.properties");
			prop.load(in);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static String getPropertyValue(String key){
		return prop.getProperty(key);
	}
}
