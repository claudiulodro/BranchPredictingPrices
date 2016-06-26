package application;

/**
 * A four-node branch predictor that makes a gentle switch when it detects a change in direction
 * @author Claudiu
 *
 */
public class StandardSoftPredictor extends AlgorithmEvaluator {
	
	public StandardSoftPredictor(){
		
		int [][] mapping = new int[][]{
			{0, 1, 1},
			{0, 2, 1},
			{1, 3, 0},
			{2, 3, 0}
		};
				
		algorithm = new StateMachine( mapping );

	}
}
