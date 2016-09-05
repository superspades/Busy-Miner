package miner;
/* Eric Madsen Mining Simulator Using Observable Pattern*/

public class MiningTrip {

	public static void main(String[] args) {
//creating observable and observer objects
		Mine rockCreek = new Mine();
		MiningResults digging = new MiningResults(rockCreek);
//beginning the subject mining actions		
		rockCreek.miningAction();		
	}
}
