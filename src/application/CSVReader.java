package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	private String filePath;
	private ArrayList prices;
	
	public CSVReader( String filePath ) throws IOException{
		
		this.filePath = filePath;
		prices = new ArrayList();
		readFile();
	}
		
	protected void readFile() throws IOException {
		FileReader file = new FileReader( filePath );
		BufferedReader reader = new BufferedReader( file );
		String buffer;
		String [] csvElementsTemp;
		
		while( ( buffer = reader.readLine() ) != null ){
			csvElementsTemp = buffer.split(",");
			
			for( int i = 0; i < csvElementsTemp.length; ++i ){
				prices.add( csvElementsTemp[i] );
			}
		}
					
		reader.close();
	}
	
	public int getNumEntries(){
		return prices.size();
	}
	
	public boolean isDone(){
		return prices.isEmpty();
	}
	
	public double pop(){
		String element = prices.remove( 0 ).toString();
		return Double.parseDouble( element );
		
	}
}
