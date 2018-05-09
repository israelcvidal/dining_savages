package dining_savages_semaphore;
import java.util.concurrent.Semaphore;
import java.lang.Thread;

public class Savage extends Thread{
	private Semaphore awakeCook, mutex, reffiled;
	private Pot pot;
	private int id; 
	
	public Savage(int id, Semaphore awakeCook, Semaphore mutex, Semaphore reffiled, Pot pot){
		this.id = id;
		this.awakeCook = awakeCook;
		this.mutex = mutex;
		this.reffiled = reffiled;
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

					this.awakeCook.release();
					this.reffiled.acquire();
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
