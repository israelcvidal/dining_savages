package dining_savages_monitor;

public class Main {

	public static void main(String[] args) {
		int m = 3;
		
		Pot pot = new Pot(m);
		Cook cook = new Cook(pot);
		Savage s0 = new Savage(0, pot);
		Savage s1 = new Savage(1, pot);
		Savage s2 = new Savage(2, pot);
		Savage s3 = new Savage(3, pot);
		Savage s4 = new Savage(4, pot);
		Savage s5 = new Savage(5, pot);


		s0.start();
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		cook.start();

		
	}

}
