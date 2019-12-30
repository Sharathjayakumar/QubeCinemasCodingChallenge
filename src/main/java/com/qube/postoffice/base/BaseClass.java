package com.qube.postoffice.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

	public static Properties prop;
	
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream propFile = new FileInputStream("/Users/sds-sarath.kj/Documents/eclipse-workspace/QubeCodingChallengeSJ/"
					+ "src/main/java/com/qube/postoffice/config/config.properties");
			prop.load(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
