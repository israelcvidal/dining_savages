package dining_savages_semaphore;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		int m = 3;
		Semaphore eat = new Semaphore(0);
		Semaphore mutex = new Semaphore(1);
		Semaphore refill = new Semaphore(0);
		
		Pot pot = new Pot(m);
		Cook cook = new Cook(refill, eat, pot);
		Savage s0 = new Savage(0, mutex, eat, refill, pot);
		Savage s1 = new Savage(1, mutex, eat, refill, pot);
		Savage s2 = new Savage(2, mutex, eat, refill, pot);
		Savage s3 = new Savage(3, mutex, eat, refill, pot);
		Savage s4 = new Savage(4, mutex, eat, refill, pot);
		Savage s5 = new Savage(5, mutex, eat, refill, pot);


		cook.start();
		s0.start();
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		
	}

}
