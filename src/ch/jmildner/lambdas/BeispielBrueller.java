package ch.jmildner.lambdas;

import ch.jmildner.tools.MyTools;

public class BeispielBrueller
{
	public static void main(String[] args)
	{
		new BeispielBrueller().doit();

	}


	private void doit()
	{

		test1();
		test2();
	}


	private void test2()
	{
		MyTools.uebOut("test2", 2);

		Katze k = new Katze();
		gibLaut(k);

		Brueller gruseligesUngeheuer = //
				() -> {
					System.out.println("uuuuuhhhhhhaaaaaa");
				};
		gibLaut(gruseligesUngeheuer);
	}


	private void test1()
	{
		MyTools.uebOut("test1", 2);

		Katze k = new Katze();
		gibLaut(k);


		Brueller gruseligesUngeheuer = new Brueller()
		{
			@Override
			public void bruellen()
			{
				System.out.println("uuuuuhhhhhhaaaaa");

			}
		};

		gibLaut(gruseligesUngeheuer);
	}


	private void gibLaut(Brueller b)
	{
		b.bruellen();
	}
}



@FunctionalInterface
interface Brueller
{
	void bruellen();
}


class Katze implements Brueller
{
	@Override
	public void bruellen()
	{
		System.out.println("miau");
	}
}
