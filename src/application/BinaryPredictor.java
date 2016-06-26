package application;

/**
 * Simple 2-node binary predictor. It basically goes "If it increased last time, it will increase this time"
 * @author Claudiu
 */
public class BinaryPredictor extends AlgorithmEvaluator {

	public BinaryPredictor(){
		
		int [][] mapping = new int[][]{
			{1, 0, 0},
			{1, 0, 1}
		};
			
		algorithm = new StateMachine( mapping );

	}
	
}
