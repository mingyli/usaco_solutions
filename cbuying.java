import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class cbuying{
	private PrintWriter outFile;
	private Scanner inFile;
	private chocolate[] choco;
	private int numTypes, budget, numCows = 11;

	public static void main(String[] args){
		cbuying a = new cbuying();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "cbuying.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numTypes = inFile.nextInt();
			budget = inFile.nextInt();
			choco = new chocolate[numTypes];
			for(int i = 0; i < numTypes; i++){
				choco[i].cost = inFile.nextInt();
				choco[i].prefer = inFile.nextInt();
			}
		}





		//print to file
		try {
		  outFile = new PrintWriter(new File("cbuying.out"));
		} catch (IOException e) {
		  
		}
		outFile.close();
	}
}

class chocolate implements Comparable<chocolate>{
	int prefer, cost;

	@Override
	public int compareTo(chocolate c){
		return 1;
	}
}