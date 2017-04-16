package application;

/**
 * One node in a branch-predicting state machine
 * @author Claudiu
 */
public class StateMachineNode {

	protected int onHigh;
	protected int onLow;
	protected boolean probablyGoingUp;
	
	/**
	 * @param onHigh - node index to go to on a price increase
	 * @param onLow - node index to go to on a price decrease
	 * @param probablyGoingUp - if state machine is in this node, are prices going up? (true for increasing, false for decreasing)
	 */
	public StateMachineNode( int onHigh, int onLow, boolean probablyGoingUp ){
		this.onHigh = onHigh;
		this.onLow = onLow;
		this.probablyGoingUp = probablyGoingUp;
	}
	
	/**
	 * Get node index to go to on a price increase
	 * @return int
	 */
	public int getOnHigh(){
		return onHigh;
	}
	
	/**
	 * Get node index to go to on a price decrease
	 * @return int
	 */
	public int getOnLow() {
		return onLow;
	}
	
	/**
	 * Get this node's outlook for future prices
	 * @return true for increasing or maintaining prices, false for decreasing
	 */
	public boolean isProbablyGoingUp(){
		return this.probablyGoingUp;
	}
	
	/**
	 * Evaluate current price and new price and determine where to go next
	 * @param current - The current price
	 * @param next - The new current price
	 * @return int - node index to go to next
	 */
	public int getNext( double current, double next ){
		if( next >= current ){
			return getOnHigh();
		}
		
		return getOnLow();
	}
	
}
