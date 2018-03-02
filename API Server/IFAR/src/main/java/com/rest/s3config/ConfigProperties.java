package com.rest.s3config;

import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	private static ConfigProperties instance = null;
	private Properties properties;
	
	
	protected ConfigProperties() throws IOException {

		properties = new Properties();
		properties.load(getClass().getClassLoader().getResourceAsStream(
				"fileLocationConfig.properties"));

	}

	public static ConfigProperties getInstance() throws Exception {
		if (instance == null) {
			try {
				instance = new ConfigProperties();
			} catch (IOException e) {
				throw new Exception(e);
			}
		}
		return instance;
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
