package propertiesFilesFunctions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class CreatingPropertyFile {
	public static void main(String[] args) {
		
		OutputStream out=null;
		Properties prop=new Properties();
		prop.setProperty("db:user","admin");
		prop.setProperty("db:password","rgukt123");
		try{
			out=new FileOutputStream("sample.properties");
			///// -----   For Storing as XML File   -----           /////
			////  out=new FileOutputStream("sample.xml");           /////
			////  prop.storeToXML(out, "Dynamic Property File");    /////
			prop.store(out, "Dynamic Property File");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}

////#Dynamic Property File 
///#Mon Jul 09 21:05:40 GMT+05:30 2012 
//email=java2novice@gmail.com 
//name=java2novice 
//domain=www.java2novice.com
