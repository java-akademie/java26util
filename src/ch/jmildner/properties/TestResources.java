package ch.jmildner.properties;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import ch.jmb.tools.MyTools;

public class TestResources
{

	public static void main(String[] args) throws IOException
	{
		testAusClassMethode();
		new TestResources()
		.testAusMemberMethode("/resources/config.properties");
		new TestResources()
		.testAusMemberMethode("/resources/config_CH.properties");
		new TestResources()
		.testAusMemberMethode("/resources/config1.properties");
	}


	private void testAusMemberMethode(String name) throws IOException
	{
		MyTools.uebOut("testAusMemberMethode: "+name,3);
		Properties props = new Properties();

		Object o = this;

		props.load(o.getClass().getResourceAsStream(name));


		Set<Object> set = props.keySet();

		for (Object key : set)
		{
			String value = props.getProperty(key.toString());
			System.out.printf("%s=%s %n", key, value);
		}
	}


	private static void testAusClassMethode()
	{

	}

}
