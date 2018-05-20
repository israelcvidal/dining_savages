package dining_savages_monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pot {
   final Lock lock = new ReentrantLock();
   final Condition eat  = lock.newCondition(); 
   final Condition refill = lock.newCondition(); 
   private int available; 
   private int m;
	
	public Pot(int m){
		this.available = 0;	
		this.m = m;
	}
	
	public void eat(int id) throws InterruptedException {

		this.lock.lock();
	    try {
	    	while (this.available == 0){
	    		System.out.println("savage "+ id + " found no food! Awake cook!");
	    		this.refill.signal();
	    		this.eat.await();
	    	}
	    	this.available -= 1;
	    	System.out.println("savage "+ id + " got 1 serving!");

	    	
    	} finally {
    		lock.unlock();
	    }
    }
	
	public void refill() throws InterruptedException {
		this.lock.lock();

		try {   
			if(this.available > 0)
				this.refill.await();
			System.out.println("Cook  is awake!");
	    	this.available += this.m;
	    	System.out.println("There's food again!");
	    	this.eat.signalAll();
	    	
    	} finally {
    		lock.unlock();
	    }
    }
}
