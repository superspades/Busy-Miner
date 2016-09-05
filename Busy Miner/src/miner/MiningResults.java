package miner;
/* Eric Madsen Mining Simulator Using Observable Pattern*/

import java.util.Observable;
import java.util.Observer;

//observer interface receiving updates from mine activity
public class MiningResults implements Observer, Report {
	Observable observable;
	private String mineral;
	private int durability;
	private int weight;
//adding a subject to be observed	
	public MiningResults(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}	
//receiving updates from the observed object data values	
	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof Mine) {
			Mine mine = (Mine)obs;
			this.mineral = mine.getMineral();
			this.durability = mine.getDurability();
			this.weight = mine.getWeight();
//calling the report method to print out updated data values
			report();
		}
		
	}
//implementation of the report interface
	public void report() {
		System.out.println("Miner has found "+mineral+
				"! the pick axe durability is now "+durability+
				"% and carry weight is "+weight+".");
	}
}
