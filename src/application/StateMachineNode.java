package application;

public class StateMachineNode {

	protected int onHigh;
	protected int onLow;
	
	StateMachineNode( int onHigh, int onLow ){
		this.onHigh = onHigh;
		this.onLow = onLow;
	}
	
	public int getOnHigh(){
		return onHigh;
	}
	
	public int getOnLow() {
		return onLow;
	}
	
	public int getNext( double current, double next ){
		if( next >= current ){
			return getOnHigh();
		}
		
		return getOnLow();
	}
	
}
