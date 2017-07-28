package day4;

import java.util.Properties;

import commonutils.CommonLib;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Properties oProperties = CommonLib.getProperties("AutomationInputs.properties");
		System.out.println(oProperties.getProperty("ie.driver.path"));

	}

}
