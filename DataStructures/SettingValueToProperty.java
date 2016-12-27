package propertiesFilesFunctions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class SettingValueToProperty {
	private Properties prop=null;
	SettingValueToProperty(){
		InputStream in=null;
		try{
			prop=new Properties();
			// Another way to load property File using Class Name
			//in=SettingValueToProperty.class.getResourceAsStream("/sample.properties");
			in=this.getClass().getResourceAsStream("/sample.properties");
			prop.load(in);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public Set<Object> getKeys(){
		Set<Object> keys= prop.keySet();
		return keys;
	}
	public String getPropertyValue(String key){
		//If Key Don't have Value we will set by This Method
		return this.prop.getProperty(key,"Default Value");
	}
}
