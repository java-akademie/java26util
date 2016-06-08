package ch.jmildner.properties;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;

public class MyProperties
{
	static MyProperties getInstance() throws IOException
	{
		return getInstance("/resources/config.properties");
	}


	static MyProperties getInstance(String cf) throws IOException
	{
		return new MyProperties(cf);
	}
	private Properties props;


	private String path;


	private String configFile;


	private MyProperties(String cf) throws IOException
	{
		path = this.getClass().getResource(cf).toString();
		props = new Properties();
		props.load(this.getClass().getResourceAsStream(cf));
		configFile = cf;
	}


	public String getConfigFile()
	{
		return configFile;
	}


	public String getPath()
	{
		return path;
	}


	// @SuppressWarnings("unchecked")
	public String getProperties()
	{
		StringBuffer sb = new StringBuffer();

		sb.append("----- " + getPath() + " -----\n");

		TreeSet<String> s = new TreeSet<String>();

		for (Enumeration<?> e = props.propertyNames(); e
				.hasMoreElements();)
		{
			s.add((String) e.nextElement());
		}

		for (Iterator<String> i = s.iterator(); i.hasNext();)
		{
			String key = i.next();
			sb.append(key + " = " + props.getProperty(key) + '\n');
		}

		return sb.toString();
	}


	public String getProperty(String key)
	{
		return props.getProperty(key);
	}
}
