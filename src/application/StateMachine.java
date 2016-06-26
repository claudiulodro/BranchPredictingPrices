package application;

/**
 * A branch prediction algorithm is represented by a state machine
 * @author Claudiu
 */
public class StateMachine {

	protected StateMachineNode [] nodes;
	protected int currentNode = 0;
	protected double lastValue = 0.0;	
	
	/**
	 * @param mapping
	 * The machine takes an 2d array integer mapping defining the properties of each node
	 * The first element in each mapping is the array index of the node to go to on a price increase
	 * The second element in each mapping is the array index of the node to go to on a price decrease
	 * The third element is positive if that node has a prediction of price increase, zero or negative for a prediction of 
	 * price decrease
	 * e.g.
	 * {
			{1, 0, 0}, //Next node is 1 on increase, 0 on decrease, and this node predicts price decrease
			{0, 1, 1} //Next node is 0 on increase, 1 on decrease, and this node predics price increase
		};
	 */
	public StateMachine(int[][] mapping) {
		nodes = new StateMachineNode[mapping.length];
		
		for( int i = 0; i < mapping.length; ++i ){
			nodes[i] = new StateMachineNode( mapping[i][0], mapping[i][1], mapping[i][2] > 0 );
		}
		
		currentNode = 0;
	}
	
	/**
	 * Get this machine's internal node array
	 * @return array of StateMachineNodes
	 */
	public StateMachineNode [] getNodes(){
		return nodes;
	}

	/**
	 * Process a new price and update the machine to reflect this new information
	 * @param newPrice
	 */
	public void run( double newPrice ){
		currentNode = nodes[currentNode].getNext( lastValue, newPrice );
		lastValue = newPrice;
	}
	
	/**
	 * Get the machine's prediction for what the next price will do
	 * @return true if the machine thinks next price will increase or maintain, false if decrease predicted
	 */
	public boolean pricesAreGoingUp(){
		return nodes[currentNode].isProbablyGoingUp();
	}
	
}
