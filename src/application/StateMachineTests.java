package application;

import junit.framework.TestCase;

public class StateMachineTests extends TestCase {
	
	public void testMachine1(){
		int [][] mapping = new int[][]{
			{1, 0},
			{1, 0}
		};
		
		StateMachine machine = new StateMachine( mapping );
		StateMachineNode [] nodes = machine.getNodes();
		
		
	}
	
}
