package com.company.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Class facilitates access to project properties.
 * 
 * @author caio.ribeiro
 * @since 23/08/2018.
 */
public class UtilProperties {

	/**
	 * LOG
	 */
	final static Logger logger = Logger.getLogger(UtilProperties.class);

	/**
	 * Method returns property
	 * 
	 * @author caio.ribeiro
	 * @since 23/08/2018.
	 * @param propertyName
	 * @return String value of property.
	 */
	public static String getProjectProperty(String propertyName) {
		
		logger.info("project.properties getProjectProperty: " + propertyName);

		String str = null;

		try (FileInputStream input = new FileInputStream("project.properties")) {

			Properties prop = new Properties();
			prop.load(input);
			str = prop.getProperty(propertyName);

		} catch (FileNotFoundException e) {
			logger.fatal(e.getMessage(), e);
		} catch (IOException e) {
			logger.fatal(e.getMessage(), e);
		}

		return str;
	}

	/**
	 * Method returns property from serenity.properties
	 * @param keyProperty
	 * @return
	 */
	public static String getSerenityProperty(String keyProperty) {

		logger.info("serenity.properties getProjectProperty: " + keyProperty);
		String str = null;

		try (FileInputStream input = new FileInputStream("serenity.properties")) {

			Properties prop = new Properties();
			prop.load(input);
			str = prop.getProperty(keyProperty);

		} catch (FileNotFoundException e) {
			logger.fatal(e.getMessage(), e);
		} catch (IOException e) {
			logger.fatal(e.getMessage(), e);
		}
		return str;
	}

}
