package application;

import junit.framework.TestCase;

public class AlgorithmTests extends TestCase {
	
	public void testBinaryAlgorithm(){
		
		BinaryPredictor algorithm = new BinaryPredictor();
		
		algorithm.run( 1.0 );
		assertTrue( 1.0 == algorithm.getAlgorithmAccuracy() );
		
		algorithm.run( 1.2 );
		assertTrue( 1.0 == algorithm.getAlgorithmAccuracy() );

		algorithm.run( 1.1 );
		assertTrue( 66.66 == algorithm.getAlgorithmAccuracyPercent() );
				
	}
	
	public void testStandardHardAlgorithm(){
		
		StandardHardPredictor algorithm = new StandardHardPredictor();
		
		algorithm.run( 10.0 );
		assertTrue( 1.0 == algorithm.getAlgorithmAccuracy() );
		
		algorithm.run( 11.2 );
		assertTrue( 1.0 == algorithm.getAlgorithmAccuracy() );
		
		algorithm.run( 8 );
		assertTrue( 66.66 == algorithm.getAlgorithmAccuracyPercent() );

		algorithm.run( 7 );
		assertTrue( 0.5 == algorithm.getAlgorithmAccuracy() );
		
		algorithm.run( 6.99 );
		assertTrue( 0.6 == algorithm.getAlgorithmAccuracy() );
		
	}
	
	public void testStandardSoftAlgorithm(){
		
		StandardSoftPredictor algorithm = new StandardSoftPredictor();
		
		algorithm.run( 10.0 );
		assertTrue( 1.0 == algorithm.getAlgorithmAccuracy() );
		
		algorithm.run( 11.2 );
		assertTrue( 1.0 == algorithm.getAlgorithmAccuracy() );
		
		algorithm.run( 7 );
		assertTrue( 66.66 == algorithm.getAlgorithmAccuracyPercent() );

		algorithm.run( 6 );
		algorithm.run( 8 );
		assertTrue( 0.4 == algorithm.getAlgorithmAccuracy() );

		algorithm.run( 7 );
		assertTrue( 33.33 == algorithm.getAlgorithmAccuracyPercent() );

	}
	
	public void testSixNodeSoftAlgorithm(){
		
		SixNodeSoftPredictor algorithm = new SixNodeSoftPredictor();
		
		algorithm.run( 23 );
		algorithm.run( 22 );
		algorithm.run( 21 );
		algorithm.run( 20 );
		assertTrue( .25 == algorithm.getAlgorithmAccuracy() );
		
		algorithm.run( 19 );
		assertTrue( .4 == algorithm.getAlgorithmAccuracy() );
	}
	
}
