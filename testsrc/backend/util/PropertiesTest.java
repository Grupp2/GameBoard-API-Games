package backend.util;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class PropertiesTest {
    private PropertiesReaderWriter propIO;

    @Before
    public void setUp() throws Exception {
	propIO = new PropertiesReaderWriter();
    }

    @Test
    public void coordinateTranslatorPropertyReadTest() {
	Properties prop = propIO.getCoordinatePropertyValues();
	if (prop.size() != 3)
	    fail("Wrong size");
	String rowData = prop.getProperty("rowDataType");
	String columnData = prop.getProperty("columnDataType");
	String isLinear = prop.getProperty("isLinear");
	return;
    }

    @Test
    public void coordinateTranslatorPropertyWriteTest() {
	Properties propRead = propIO.getCoordinatePropertyValues();
	String rowData = propRead.getProperty("rowDataType");
	String columnData = propRead.getProperty("columnDataType");
	String isLinear = propRead.getProperty("isLinear");
	
	Properties propReadBackup = new Properties();
	propReadBackup.setProperty("rowDataType", rowData);
	propReadBackup.setProperty("columnDataType", columnData);
	propReadBackup.setProperty("isLinear", isLinear);
	
	Properties propWrite = new Properties();
	propWrite.setProperty("rowDataType", "test");
	propWrite.setProperty("columnDataType", "test");
	propWrite.setProperty("isLinear", "test");
	propIO.setCoordinatePropertyValues(propWrite);
	
	Properties testPropRead = propIO.getCoordinatePropertyValues();
	if (!testPropRead.getProperty("rowDataType").equals("test"))
	    fail("RowDataType is incorrect!");
	if (!testPropRead.getProperty("columnDataType").equals("test"))
	    fail("ColumnDataType is incorrect!");
	if (!testPropRead.getProperty("isLinear").equals("test"))
	    fail("IsLinear is incorrect!");
	propIO.setCoordinatePropertyValues(propReadBackup);
    }

}
