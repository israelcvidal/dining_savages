package dining_savages_semaphore;
import java.util.concurrent.Semaphore;
import java.lang.Thread;

public class Savage extends Thread{
	private Semaphore mutex, eat, refill;
	private Pot pot;
	private int id; 
	
	public Savage(int id, Semaphore mutex, Semaphore eat, Semaphore refill, Pot pot){
		this.id = id;
		this.mutex = mutex;
		this.eat = eat;
		this.refill = refill;
		this.pot = pot;
	}
	
	public void eat(int foodLeft) throws InterruptedException {
		System.out.println("Savage " + this.id + " is eating. Pot has " + foodLeft + " left");
		Thread.sleep(1000);
	}
	
	public void run() {
		while(true) {
			try {
				this.mutex.acquire();
				
				if(!this.pot.hasFood()) {
					System.out.println("Savage " + this.id + " found no food!");

					this.refill.release();
					this.eat.acquire();
				}
				
				int foodLeft = this.pot.getFood();
				this.mutex.release();
				this.eat(foodLeft);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
