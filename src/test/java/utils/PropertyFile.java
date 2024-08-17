package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

public class PropertyFile {
	

	private static FileInputStream fis;
	private static Properties prop = null;

	public static String getProperty(String property) {		

		try {
			fis = new FileInputStream(new File("config.properties"));
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException e) {
			e.printStackTrace(System.out);
		} catch(IOException e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace(System.out);
			}
		}
		return prop.getProperty(property).trim();
	}

}
