package miner;
/* Eric Madsen Mining Simulator Using Observable Pattern*/

import java.util.Observable;

//create observable subject Mine that observers can receive updates from
public class Mine extends Observable{
	private String mineral;
	private int durability;
	private int weight;
	
	public Mine() {}
	
//notify observers that there has been a change in values	
	public void valueChange() {
		setChanged();
		notifyObservers();
	}
//update values that have been changed and call the observer notifier
	public void setValueChange(String mineral, int durability, int weight) {
		this.mineral = mineral;
		this.durability = durability;
		this.weight = weight;
		valueChange();
	}
//get method so observers can call for the current mineral	
	public String getMineral() {
		return mineral;
	}
//get method so observers can call for the current axe durability
	public int getDurability() {
		return durability;
	}
//get method so observers can call for the current carry weight	
	public int getWeight() {
		return weight;
	}
//method that provides the data as a miner mines for minerals
	public void miningAction() {
		int durability = 100;
		int weight = 0;
//miner will continue to mine until the axe durability is depleted or carry weight reaches 200		
		while (weight <= 200 && durability >= 0) {
			try {
//program pauses 5 seconds between mining attempts
				Thread.sleep(5000);     
			} catch (InterruptedException ex) {
				continue;
			}
//miner has a 30% chance of finding minerals
			double luck = Math.random() * 100;
			if (luck > 70) { 
//miner finds a random mineral when mining succeeds and setValueChange is called with new data
				int index = 0 + (int) (Math.random() * ((3 - 0) + 1));
				switch (index) {
				case 0:
					weight +=8;
					durability -= 12;
					setValueChange("gold", durability, weight);
					break;
				case 1:
					weight +=12;
					durability -= 14;
					setValueChange("iron", durability, weight);
					break;
				case 2:
					weight +=10;
					durability -= 13;
					setValueChange("copper", durability, weight);
					break;
				case 3:
					weight +=5;
					durability -= 16;
					setValueChange("diamond", durability, weight);
					break;
				}				
			}
//if miner does not find minerals message is displayed and durability adjusted
			else {
				durability -= 6;
				System.out.println("dig...dig...dig  Darn no minerals, pick axe durability is now "+durability+"%");
			}
		}
		System.out.println("Mining is now complete, please purchase a new pick axe or head to the "
				+ "bank to sell your minerals!");
	}
}

