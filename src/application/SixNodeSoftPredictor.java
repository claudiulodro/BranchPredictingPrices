package application;

/**
 * A six-node branch predictor that makes a gentle switch when it detects a change in direction
 * More nodes makes prediction changes take longer, reducing thrashing
 * @author Claudiu
 */
public class SixNodeSoftPredictor extends AlgorithmEvaluator {

	public SixNodeSoftPredictor(){
		int [][] mapping = new int[][]{
			{0, 1, 1},
			{0, 2, 1},
			{1, 3, 1},
			{2, 4, 0},
			{3, 5, 0},
			{4, 5, 0}
		};
				
		algorithm = new StateMachine( mapping );

	}
}
