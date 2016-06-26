package application;

/**
 * A four-node branch predictor that makes a drastic switch when it detects a change in direction
 * @author Claudiu
 */
public class StandardHardPredictor extends AlgorithmEvaluator {

	public StandardHardPredictor(){
		
		int [][] mapping = new int[][]{
			{0, 1, 1},
			{0, 3, 1},
			{0, 3, 0},
			{2, 3, 0}
		};
				
		algorithm = new StateMachine( mapping );

	}
}
