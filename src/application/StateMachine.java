package application;

public class StateMachine {

	protected StateMachineNode [] nodes;
	protected int currentNode = 0;
	protected double lastValue;	
	
	public StateMachine(int[][] mapping) {
		nodes = new StateMachineNode[mapping.length];
		
		for( int i = 0; i < mapping.length; ++i ){
			nodes[i] = new StateMachineNode( mapping[i][0], mapping[i][1] );
		}
		
		currentNode = 0;
	}
	
	public StateMachineNode [] getNodes(){
		return nodes;
	}

}
