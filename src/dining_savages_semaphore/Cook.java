package dining_savages_semaphore;
import java.util.concurrent.Semaphore;

public class Cook extends Thread {
	private Semaphore refill, eat;
	private Pot pot;
	
	public Cook(Semaphore refill, Semaphore eat, Pot pot){
		this.refill = refill;
		this.eat = eat;
		this.pot = pot;
	}
	
	public void refill(int m) {
		System.out.println("Cook  is awake!");
		this.pot.refill(m);
		System.out.println("Pot now has food again!");
	}
	
	public void run() {
		while(true) {
			try {
				this.refill.acquire();
				this.refill(this.pot.getM());
				this.eat.release();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
