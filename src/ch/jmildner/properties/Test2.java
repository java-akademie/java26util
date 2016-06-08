package ch.jmildner.properties;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

import ch.java_akademie.tools.MyTools;

public class Test2
{


	public static void main(String[] args) throws IOException
	{
		testLocale();
		testProperties1();
		testProperties2();
	}


	private static void testLocale()
	{
		// Vorhandene Locale: US, UK, GERMANY, GERMAN (nur Sprache)
		// FRENCH, FRANCE (nur Sprache), ITALY, ITALIAN (nur Sprache)
		// ENGLISH (nur Sprache) und noch einige mehr

		Locale ll = new Locale("be");

		for (Locale s : new Locale[] { ll, Locale.US, Locale.UK,
				Locale.ENGLISH, Locale.GERMANY, Locale.GERMAN,
				Locale.ITALY, Locale.ITALIAN })
		{
			System.out.println("Identifikation: " + s.toString()
					+ " Country:" + s.getDisplayCountry()
					+ " Language:" + s.getDisplayLanguage());
		}

		for (Locale s : Locale.getAvailableLocales())
		{
			System.out.println("Identifikation: " + s.toString()
					+ " Country:" + s.getDisplayCountry()
					+ " Language:" + s.getDisplayLanguage());
		}
		System.out.println("Default:" + Locale.getDefault());
		Locale l = new Locale("ja", "AT");
		System.out.println(l);
		System.out.println("Country :" + l.getCountry());
		System.out.println("Language:" + l.getLanguage());
		System.out.println("Language:" + l.getDisplayLanguage());

	}


	private static void testProperties1() throws IOException
	{
		// selbsterstellt
		Properties props = new Properties();
		props.load(Thread.currentThread().getClass()
				.getResourceAsStream("/resources/config.properties"));
		for (Enumeration<?> e = props.propertyNames(); e
				.hasMoreElements();)
		{
			String key = (String) e.nextElement();
			System.out.println(key + "..." + props.getProperty(key));
		}
		System.out.println(".......................................");
		props.list(System.out);
		String einWert = props.getProperty("test.ueberschrift");
		System.out.println(einWert);
	}


	private static void testProperties2() throws IOException
	{
		MyTools.uebOut("testProperties2()", 3);
		Properties props = new Properties();
		props.load(Thread.currentThread().getClass()
				.getResourceAsStream("/resources/config.properties"));
		props.list(System.out);
		FileWriter w = new FileWriter("properties/resources/config2gen.properties");
		props.store(w, "generiert aus /resources/config.properties");
		w.close();
		OutputStream s = new FileOutputStream("properties/resources/config2gen.xml");
		props.storeToXML(s, "generiert aus /resources/config.properties");
		s.close();

	}
}
