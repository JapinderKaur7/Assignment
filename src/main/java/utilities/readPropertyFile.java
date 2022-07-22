package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readPropertyFile {
	
	private Properties prop;
	public Properties readPropfile() throws IOException {
		prop= new Properties();
		//FileInputStream file= new FileInputStream("C:\\Automation\\Workspace\\Amazon\\config.properties");
		FileInputStream file= new FileInputStream("C:\\Automation\\Workspace\\Assignment\\config.properties");
		prop.load(file);

		return prop;
		
	}

}
