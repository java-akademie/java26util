package ch.jmildner.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.java_akademie.tools.MyTools;

public class ForEach
{

	public static void main(String[] args)
	{
		List<Integer> l = new ArrayList<Integer>();
		
		for (int i = 1; i <= 100; i++)
		{
			l.add(MyTools.getRandom());
		}


		Collections.sort(l);
		Collections.sort(l, (p1, p2) -> (Integer.compare(p1, p2)));


		l.forEach(x -> System.out.println(x));

	}

}
