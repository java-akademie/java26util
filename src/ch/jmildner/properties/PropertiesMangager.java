package ch.jmildner.properties;

import java.io.IOException;
import java.util.HashMap;

public class PropertiesMangager
{
	static HashMap<String, MyProperties> properties = new HashMap<String, MyProperties>();


	/**
	 * Erzeugt beim ersten Mal eine Instanz der <default>
	 * Properties-Daten (@see MyProperties) und legt diese unter
	 * <"default"> in der HashMap <properties> ab.<br>
	 * Gibt es unter diesem Namen schon Properties-Daten, werden diese
	 * geliefert.
	 * 
	 * @param configName
	 * @return MyProperties
	 * @throws IOException
	 */
	public static MyProperties getInstance() throws IOException
	{
		return PropertiesMangager.getInstance("default");
	}


	/**
	 * Erzeugt beim ersten Mal eine Instanz der <default>
	 * Properties-Daten (@see MyProperties) und legt diese unter
	 * <configName> in der HashMap <properties> ab.<br>
	 * Gibt es unter diesem Namen schon Properties-Daten, werden diese
	 * geliefert.
	 * 
	 * @param configName
	 * @return MyProperties
	 * @throws IOException
	 */
	public static MyProperties getInstance(String configName)
			throws IOException
	{
		if (!(properties.containsKey(configName)))
		{
			MyProperties mp = MyProperties.getInstance();
			properties.put(configName, mp);
		}
		return properties.get(configName);
	}


	/**
	 * Erzeugt beim ersten Mal eine Instanz auf die in <configFile>
	 * bezeichnete Properties-Daten und legt diese unter <configName> in
	 * der HashMap <properties> ab.<br>
	 * Gibt es unter diesem Namen schon Properties-Daten, werden diese
	 * ungeachtet dem Inhalt von <configFile> geliefert.
	 * 
	 * @param configName
	 * @param configFile
	 * @return MyProperties
	 * @throws IOException
	 */
	public static MyProperties getInstance(String configName,
			String configFile) throws IOException
	{
		if (!(properties.containsKey(configName)))
		{
			MyProperties mp = MyProperties.getInstance(configFile);
			properties.put(configName, mp);
		}
		return properties.get(configName);
	}
}
