import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class photo{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numCows, numPairs;
	private int[] pair1, pair2;

	public static void main(String[] fred){
		photo a = new photo();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "photo.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numCows = inFile.nextInt();
			numPairs = inFile.nextInt();
			pair1 = pair2 = new int[numPairs];
			for(int i = 0; i < numPairs; i++){
				pair1[i] = inFile.nextInt();
				pair2[i] = inFile.nextInt();
			}
		}

		int ans = 0;
		for(int i = 0; i < numPairs; i++){
			for(int j = i; j < numPairs; j++){
			}
		}



		//print to file
		try {
		  outFile = new PrintWriter(new File("photo.out"));
		} catch (IOException e) {
		  
		}
		outFile.println(ans);
		outFile.close();
	}
}