package dining_savages_semaphore;

public class Pot {	
	private int available; 
	private int m;
	
	public Pot(int m){
		this.available = 0;	
		this.m = m;
	}
	
	public int getFood() {
		return this.available -= 1;
	}
	
	public void refill(int m) {
		this.available += m;
	}
	
	public boolean hasFood() {
		if(this.available > 0)
			return true;
		return false;
	}

	public int getM() {
		return m;
	}

	public int getAvailable() {
		return this.available;
	}
	
}
