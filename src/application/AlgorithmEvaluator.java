package application;

/**
 * Provides the reusable groundwork for evaluating one algorithmn
 * @author Claudiu
 *
 */
public class AlgorithmEvaluator {

	protected StateMachine algorithm;
	protected boolean lastGuess = true;
	protected double lastVal = 0;
	protected int correct = 0;
	protected int total = 0;
		
	/**
	 * Run the algorithm while collecting metrics
	 * @param next - next price value
	 */
	public void run( double next ){
		boolean newGuess;
		
		algorithm.run( next );
		if( lastGuess && next >= lastVal ){
			++correct;
		}
		
		if( !lastGuess && next < lastVal ){
			++correct;
		}
		
		newGuess = algorithm.pricesAreGoingUp();
		++total;
		lastGuess = newGuess;
		lastVal = next;
				
	}
	
	/**
	 * Get the number of correct guesses the algorithm has made
	 * @return int
	 */
	public int getNumberCorrect(){
		return correct;
	}
	
	/**
	 * Get the total number of guesses the algorithm has made
	 * @return int
	 */
	public int getTotalGuessesMade(){
		return total;
	}
	
	/**
	 * Get raw algorithm accuracy
	 * @return double - decimal fraction of guesses that were correct
	 */
	public double getAlgorithmAccuracy(){
		return ((double)correct) / ((double)total);
	}
	
	/**
	 * Get algorithm accuracy in percentage
	 * @return double - percentage of guesses that were correct
	 */
	public double getAlgorithmAccuracyPercent(){
		return 100 * ( Math.floor(getAlgorithmAccuracy() * 10000) / 10000 );
	}
	
	public void printEvaluation(){
		System.out.println( "This algorithm had " + correct + " correct guesses out of " + total + " data points, for a total accuracy of " + getAlgorithmAccuracyPercent() + "%." );
	}
	
}
