package application;

import junit.framework.TestCase;

public class StateMachineNodeTests extends TestCase {

	public void testConstructor(){
		StateMachineNode node = new StateMachineNode( 1, 0 );
		
		assertEquals( node.getOnHigh(), 1);
		assertEquals( node.getOnLow(), 0 );
	}
	
	public void testHighValue(){
		StateMachineNode node = new StateMachineNode( 1, 0 );
		int nextNode = node.getNext( 50.0, 50.34 );
		
		assertEquals( node.getOnHigh(), nextNode );
	}
	
	public void testLowValue() {
		StateMachineNode node = new StateMachineNode( 1, 0 );
		int nextNode = node.getNext( 120.0, 50.34 );
		
		assertEquals( node.getOnLow(), nextNode );

	}
	
}
