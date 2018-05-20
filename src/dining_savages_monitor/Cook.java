package dining_savages_monitor;

public class Cook extends Thread {
	private Pot pot;
	
	public Cook(Pot pot){
		this.pot = pot;
	}
	
	public void refill() {
		try {
			this.pot.refill();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			this.refill();
		}
	}
}
