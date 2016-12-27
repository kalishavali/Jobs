package propertiesFilesFunctions;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesFiles {
	private Properties prop=null;
	PropertiesFiles(){
		InputStream in=null;
		try{
			prop=new Properties();
			in=this.getClass().getResourceAsStream("/sample.properties");
			prop.load(in);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public String getPropertyValue(String key){
		return this.prop.getProperty(key);
	}
	public static void main(String[] args) {
		PropertiesFiles pf=new PropertiesFiles();
		System.out.println(pf.getPropertyValue("db.user"));
	}
	
}
