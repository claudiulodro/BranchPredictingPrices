package application;

import junit.framework.TestCase;

public class StateMachineTests extends TestCase {
	
	public void testMachine1(){

		int [][] mapping = new int[][]{
			{1, 0, 0},
			{1, 0, 1}
		};
		
		StateMachine machine = new StateMachine( mapping );
		StateMachineNode [] nodes = machine.getNodes();
		
		assertEquals( 0, nodes[0].getOnLow() );
		assertEquals( 1, nodes[1].getOnHigh() );
		
		machine.run( 20.0 );
		assertEquals( true, machine.pricesAreGoingUp() );
		
		machine.run( 20.0 );
		assertEquals( true, machine.pricesAreGoingUp() );

		machine.run( 24.1 );
		assertEquals( true, machine.pricesAreGoingUp() );

		machine.run( 22.0 );
		assertEquals( false, machine.pricesAreGoingUp() );

		machine.run( 20.0 );
		assertEquals( false, machine.pricesAreGoingUp() );
		
		machine.run( 20.01 );
		assertEquals( true, machine.pricesAreGoingUp() );

	}
	
	public void testMachine2(){
		int [][] mapping = new int[][]{
			{0, 1, 1},
			{0, 3, 1},
			{0, 3, 0},
			{2, 3, 0}
		};
			
		StateMachine machine = new StateMachine( mapping );
		StateMachineNode [] nodes = machine.getNodes();
			
		assertEquals( 2, nodes[3].getOnHigh() );
		
		machine.run( 12.0 );
		machine.run( 14 );
		assertEquals( true, machine.pricesAreGoingUp() );

		machine.run(13.9);
		assertEquals( true, machine.pricesAreGoingUp() );

		machine.run(13.8);
		assertEquals( false, machine.pricesAreGoingUp() );
			
		machine.run(13.9);
		assertEquals( false, machine.pricesAreGoingUp() );
			
		machine.run( 14 );
		assertEquals( true, machine.pricesAreGoingUp() );

	}
	
	public void testMachine3(){
		int [][] mapping = new int[][]{
			{0, 1, 1},
			{0, 2, 1},
			{1, 3, 0},
			{2, 3, 0}
		};
			
		StateMachine machine = new StateMachine( mapping );

		machine.run( 12.0 );
		machine.run( 14 );
		assertEquals( true, machine.pricesAreGoingUp() );

		machine.run(13.9);
		assertEquals( true, machine.pricesAreGoingUp() );

		machine.run(13.8);
		assertEquals( false, machine.pricesAreGoingUp() );
			
		machine.run(13.9);
		assertEquals( true, machine.pricesAreGoingUp() );
			
		machine.run(13.8);
		assertEquals( false, machine.pricesAreGoingUp() );

	}
	
	public void testMachine4(){
		int [][] mapping = new int[][]{
			{0, 1, 1},
			{0, 2, 1},
			{1, 3, 1},
			{2, 4, 0},
			{3, 5, 0},
			{4, 5, 0}
		};
			
		StateMachine machine = new StateMachine( mapping );
		
		machine.run( 14 );
		assertEquals( true, machine.pricesAreGoingUp() );

		machine.run(13.9);
		assertEquals( true, machine.pricesAreGoingUp() );

		machine.run(13.8);
		assertEquals( true, machine.pricesAreGoingUp() );
			
		machine.run(13.9);
		assertEquals( true, machine.pricesAreGoingUp() );
			
		machine.run(13.8);
		machine.run(13.7);
		machine.run(13.6);
		assertEquals( false, machine.pricesAreGoingUp() );

	}
}
