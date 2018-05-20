package dining_savages_monitor;

public class Savage extends Thread{
	private Pot pot;
	private int id; 
	
	public Savage(int id, Pot pot){
		this.id = id;
		this.pot = pot;
	}
	
	public void eat() throws InterruptedException {
		this.pot.eat(this.id);
		Thread.sleep(1000);
	}
	
	public void run() {
		while(true) {
			try {
				this.eat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
