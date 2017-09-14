package ch.jmildner.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ch.jmb.tools.MyTools;

public class SortierenVonListen
{

	public static void main(String[] args)
	{
		test1();
		test2();
	}


	static void test1()
	{
		MyTools.uebOut("Test1",2);
		
		final List<String> names = Arrays.asList("michael", "max", "stefan", "andy");

		Collections.sort(names);

		System.out.println(names.toString());

		Collections.sort(names, (s1, s2) -> (Integer.compare(s2.length(), s1.length())));

		System.out.println(names.toString());

		Collections.sort(names, (s2, s1) -> (s1.compareTo(s2)));

		System.out.println(names.toString());

	}


	static void test2()
	{
		MyTools.uebOut("Test2",2);
		
		List<Person> personen= new ArrayList<Person>();

		personen.add(new Person(3, "michael"));
		personen.add(new Person(4, "max"));
		personen.add(new Person(2, "andy"));
		personen.add(new Person(1, "stefan"));

		
		Collections.sort(personen, (p1,p2)->(Integer.compare(p2.getId(),p1.getId())));

		System.out.println(personen.toString());
		
		Collections.sort(personen, (p1,p2)->(p1.getName().compareTo(p2.getName())));

		System.out.println(personen.toString());
		
		Collections.sort(personen, (p2,p1)->(p1.getName().compareTo(p2.getName())));

		System.out.println(personen.toString());

		Collections.sort(personen, (s1, s2) -> (Integer.compare(s1.getName().length(), s2.getName().length())));

		System.out.println(personen.toString());

	
	}
}
