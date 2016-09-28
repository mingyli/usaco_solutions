import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class icow{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numSongs, numPlayed;
	private int[] playNumber;

	public static void main(String[] args){
		icow ic = new icow();
		ic.Run();
	}

	public void Run(){
		String inputFile = "icow.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numSongs = inFile.nextInt();
			numPlayed = inFile.nextInt();
			//System.out.println(numPlayed);
			//System.out.println(numCows);
		}


		playNumber = new int[numPlayed];
		int[] ratings = new int[numSongs];
		for(int i = 0; i < numSongs; i++){
			ratings[i] = inFile.nextInt();
			//playNumber[i] = 0;
		}
		//System.out.print(ratings[2]);


		for(int i = 0; i < numPlayed; i++){
			int max = 0;
			for(int j = 0; j < ratings.length; j++){
				if(ratings[j] > max){
					max = ratings[j];
					playNumber[i] = j + 1;
				}
			}
			//System.out.println(max);

			int leftover = max % (numSongs - 1);
			int pointseach = max / (numSongs - 1);
			for(int j = 0; j < ratings.length; j++){
				if(j != playNumber[i] - 1){
					ratings[j] += pointseach;
				}
				else
					ratings[j] = 0;
			}


			int count = 0;
			while(leftover != 0){
				if(count != playNumber[i]-1){
					ratings[count]++;
					leftover--;
				}
				count++;
			}



			// if(i == 0){
			// 	System.out.println(ratings[0] + " " + ratings[1] + " " + ratings[2]);
			// }
		}

		// int max = 0;
		// for(int j = 0; j < ratings.length; j++){
		// 	if(ratings[j] > max){
		// 		max = ratings[j];
		// 		playNumber[numPlayed - 1] = j + 1;
		// 	}
		// }


		try {
		  outFile = new PrintWriter(new File("icow.out"));
		} catch (IOException e) {
		  
		}
		//outFile.println (numPlayed);
		for(int i = 0; i < numPlayed; i++){
			outFile.println(playNumber[i]);
		}
		outFile.close();

	}
}