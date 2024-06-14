package Learning.Testing;

import java.util.Properties;
import java.io.*;
import java.lang.RuntimeException;

public class Readconfig 
{
		Properties properties;
		//String path= "C:\\Users\\kumar\\eclipse-workspace\\Testing\\configuration\\config.properties";
		String path="C:\\Users\\kumar\\eclipse-workspace\\Testing\\configuration\\config.properties";
		
		public Readconfig() throws IOException
		{
			properties= new Properties();
			FileInputStream file= new FileInputStream(path);
			properties.load(file);
		}
		
		public String getURl()
		{
			String url =properties.getProperty("url");
			if(url!= null)			
				return url;			
			else
				throw new RuntimeException("URL is not specified in Config File");				
		}
		public String getusername()
		{
			String usrname=properties.getProperty("username");
			if(usrname!=null)
				return usrname;
			else
				throw new RuntimeException("username is not specified in file");
		}
		public String getpswrd()
		{
			String paswrd= properties.getProperty("password");
			if(paswrd!=null)
				return paswrd;
			else
				throw new RuntimeException("Password is not Specified in config file");
		}
}
