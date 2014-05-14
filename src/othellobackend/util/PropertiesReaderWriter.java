package othellobackend.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderWriter
{
	private Properties coordinateProp;
	private String coordinatePropFileName = "coordinates.properties";
	
	public PropertiesReaderWriter() {
		coordinateProp = new Properties();
		if (!new File(coordinatePropFileName).exists())
			InitializeCoordinatePropertyFile();
	}
	
	private boolean InitializeCoordinatePropertyFile() {
		try {
			FileOutputStream fOut = new FileOutputStream(coordinatePropFileName);
			coordinateProp.setProperty("rowDataType", "");
			coordinateProp.setProperty("columnDataType", "");
			coordinateProp.setProperty("isLinear", "false");
			coordinateProp.store(fOut, null);
			fOut.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Properties getCoordinatePropertyValues() {
		try {
			FileInputStream input = new FileInputStream(coordinatePropFileName);
			coordinateProp.load(input);
			input.close();
			return coordinateProp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean setCoordinatePropertyValues(Properties coordinateProp) {
		try {
			FileOutputStream output = new FileOutputStream(coordinatePropFileName);
			coordinateProp.store(output, null);
			output.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
