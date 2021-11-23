package com.Sumtotal.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
	Properties pro;
	FileInputStream src;

	public ReadConfig()
	{	
		try {			
			 src =	new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\Config.properties");	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pro = new Properties();
			pro.load(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{
		return pro.getProperty("baseUrl");
	}
	public String getUsername()
	{
		return pro.getProperty("Username");
	}
	public String getPassword()
	{
		return pro.getProperty("Password");
	}
}
