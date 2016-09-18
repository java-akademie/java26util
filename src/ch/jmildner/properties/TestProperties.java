package ch.jmildner.properties;

import java.io.IOException;



public class TestProperties
{

	public static void main(String[] args) throws Exception
	{
		test1();
	}


	static void test1() throws IOException
	{
		MyProperties ts1, ts2, ts3;
		try
		{
			ts1 = PropertiesMangager.getInstance("minimum",
					"/resources/config.properties");
			System.out.println(ts1.getProperties());
		}
		catch (Exception e)
		{
			ts1 = null;
			System.out.println("Property Daten nicht vorhanden ");
		}
		ts2 = PropertiesMangager.getInstance("a",
				"/resources/config.properties");
		ts3 = PropertiesMangager.getInstance("a",
				"/resources/config.properties");

		System.out.println(ts2.getProperties());
		System.out.println(ts3.getProperties());

		ts1 = PropertiesMangager.getInstance("b",
				"/resources/config.properties");
		ts2 = PropertiesMangager.getInstance("b",
				"/resources/config.properties");
		ts3 = PropertiesMangager.getInstance("b",
				"/resources/config.properties");

		System.out.println(ts1.getProperties());
		System.out.println(ts2.getProperties());
		System.out.println(ts3.getProperties());

		ts1 = PropertiesMangager.getInstance("c");
		ts2 = PropertiesMangager.getInstance("c");
		ts3 = PropertiesMangager.getInstance("c");

		System.out.println(ts1.getProperties());
		System.out.println(ts2.getProperties());
		System.out.println(ts3.getProperties());
	}
}
