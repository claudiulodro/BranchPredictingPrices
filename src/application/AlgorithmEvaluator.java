package application;

public abstract class AlgorithmEvaluator {

	protected StateMachine algorithm;
	protected boolean lastGuess = true;
	protected int correct = 0;
	protected int total = 0;
	
	public void run( double next ){
		boolean newGuess;
		
		algorithm.run( next );
		newGuess = algorithm.pricesAreGoingUp();
		if( newGuess == lastGuess ){
			++correct;
		}
		++total;
		lastGuess = newGuess;
		
	}
	
	public double getAlgorithmAccuracy(){
		return correct / total;
	}
	
	public double getAlgorithmAccuracyPercent(){
		return Math.floor(getAlgorithmAccuracy() * 100) / 100;
	}
	
}
