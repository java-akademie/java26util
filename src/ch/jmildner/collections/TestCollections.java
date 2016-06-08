package ch.jmildner.collections;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import ch.java_akademie.tools.StoppUhr;

public class TestCollections
{

	public static void main(String[] args)
	{

		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1, "hugo");
		map.put(2, "fritz");
		map.put(3, "fritz");
		map.put(4, "fritz");
		map.put(5, "fritz");
		map.put(6, "fritz");
		map.put(7, "fritz");
		map.put(8, "fritz");
		map.put(9, "fritz");
		map.put(10, "fritz");

		Set<Entry<Integer, String>> entrySet = map.entrySet();

		System.out.println(entrySet);

		for (Entry<Integer, String> e : entrySet)
		{
			//System.out.printf("%s=%s %n", e.getKey(), e.getValue());
			zeitTest(e);
		}

	}


	private static void zeitTest(Entry<Integer, String> e)
	{

		if (e.getKey() %2==0)
		{
			StoppUhr u = new StoppUhr();
			for (int i = 1; i <= 1100000; i++)
			{
				String.format("%s", e.getKey());
			}
			u.getDauer();
		}
		else
		{
			StoppUhr u = new StoppUhr();
			for (int i = 1; i <= 1100000; i++)
			{
				String.format("%d", e.getKey());
			}
			u.getDauer();
		}
	}
}
