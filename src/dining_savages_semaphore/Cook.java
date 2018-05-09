package dining_savages_semaphore;
import java.util.concurrent.Semaphore;

public class Cook extends Thread {
	private Semaphore awakeCook, reffiled;
	private Pot pot;
	
	public Cook(Semaphore awakeCook, Semaphore reffiled, Pot pot){
		this.awakeCook = awakeCook;
		this.reffiled = reffiled;
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
				this.awakeCook.acquire();
				this.refill(this.pot.getM());
				this.reffiled.release();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
