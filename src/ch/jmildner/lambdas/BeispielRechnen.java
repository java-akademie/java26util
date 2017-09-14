package ch.jmildner.lambdas;

import ch.jmb.tools.MyTools;

public class BeispielRechnen
{
	public static void main(String[] args)
	{
		new BeispielRechnen().doit();

	}


	private void doit()
	{
		test2();
		test1();
	}


	private void test1()
	{
		MyTools.uebOut("test1", 2);

		Rechner<Double> rechner = new Rechner<Double>()
		{
			@Override
			public Double rechnen(Double a, Double b, char op)
			{
				switch (op)
				{
					case '+':
						return a + b;
					case '-':
						return a - b;
					case '*':
						return a * b;
					case '/':
						return a / b;
					case '%':
						return a % b;
				}
				return 0d;
			}
		};

		rechne(rechner);
	}


	private void test2()
	{
		MyTools.uebOut("test2", 2);

		Rechner<Double> rechner = //
				(Double a, Double b, char op) -> {
					switch (op)
					{
						case '+':
							return a + b;
						case '-':
							return a - b;
						case '*':
							return a * b;
						case '/':
							return a / b;
						case '%':
							return a % b;
					}
					return 0.0;
				};

		rechne(rechner);
	}



	private void rechne(Rechner<Double> r)
	{
		System.out.println(r.rechnen(5d, 7d, '+'));
		System.out.println(r.rechnen(5d, 7d, '-'));
		System.out.println(r.rechnen(5d, 7d, '*'));
		System.out.println(r.rechnen(5d, 7d, '/'));
		System.out.println(r.rechnen(5d, 7d, '%'));
	}
}



@FunctionalInterface
interface Rechner<T>
{
	T rechnen(T a, T b, char op);
}


