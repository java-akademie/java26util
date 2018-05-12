package ch.jmildner.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.jmildner.tools.MyTools;

public class ForEach
{

	public static void main(String[] args)
	{
		test1();
		test2();

	}


	 static void test2()
	{
		MyTools.uebOut("Test2", 2);

	}


	 static void test1()
	{
		MyTools.uebOut("Test1 - Sort", 2);

		List<Integer> l = new ArrayList<Integer>();

		for (int i = 1; i <= 5; i++)
		{
			l.add(MyTools.getRandom());
		}

		System.out.println("\n--- unsortiert ---");

		l.forEach(x -> System.out.println(x));

		Collections.sort(l);

		System.out.println("\n--- aufsteigend sortiert ---");

		l.forEach(x -> System.out.println(x));

		Collections.sort(l, (p1, p2) -> (Integer.compare(p2, p1)));

		System.out.println("\n--- absteigend sortiert ---");

		l.forEach(x -> System.out.println(x));

		System.out.println();
	}

}
