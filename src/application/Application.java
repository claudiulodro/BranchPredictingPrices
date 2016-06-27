package application;

import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		
		if( args.length < 1 ){
			System.out.println( "USAGE: Application PATH/TO/FILENAME.csv");
			return;
		}

		double currentPrice;
		BinaryPredictor bPredictor = new BinaryPredictor();
		StandardHardPredictor shPredictor = new StandardHardPredictor();
		StandardSoftPredictor ssPredictor = new StandardSoftPredictor();
		SixNodeSoftPredictor snfPredictor = new SixNodeSoftPredictor();
		String fileName = args[0];
				
		try {
			CSVReader reader = new CSVReader( fileName );
			
			while( !reader.isDone() ){

				currentPrice = reader.pop();
				
				bPredictor.run( currentPrice );
				shPredictor.run( currentPrice );
				ssPredictor.run( currentPrice );
				snfPredictor.run( currentPrice );
				
			}
			
			System.out.println( "Binary predictor results: " );
			bPredictor.printEvaluation();
			System.out.println();
			
			System.out.println( "Standard hard predictor results: " );
			shPredictor.printEvaluation();
			System.out.println();
			
			System.out.println( "Standard soft predictor results: " );
			ssPredictor.printEvaluation();
			System.out.println();
			
			System.out.println( "Six node soft predictor results: " );
			snfPredictor.printEvaluation();
			System.out.println();
			
			System.out.println( "Evaluation finished" );
			
		}
		catch( IOException x ){
			System.err.println( x.getMessage() );
		}
		
	}

}
