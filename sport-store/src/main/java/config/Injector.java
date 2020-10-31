package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;


import javax.management.InstanceNotFoundException;

public class Injector {
	private static final String IOC_CONFIG_FILE_NAME="/home/cuong/eclipse-workspace/Java/sport-store/src/main/resources/ioc.properties";
	
	private Injector() {
		throw new UnsupportedOperationException();
	}
	
	public static Object getInstance(String key) throws InstanceNotFoundException{
		try(InputStream input=new FileInputStream(IOC_CONFIG_FILE_NAME)){
			Properties properties =new Properties();
			properties.load(input);
			String classname=properties.getProperty(key);
			return Class.forName(classname).getDeclaredConstructor().newInstance();
		}catch(IOException | InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e)
		{
			e.printStackTrace();
            throw new InstanceNotFoundException(
                    "Can't create instance of " + key + " base on the configuration of " + IOC_CONFIG_FILE_NAME);
		}
	}
}
