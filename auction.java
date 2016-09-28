import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class auction{
	private PrintWriter outFile;
	private Scanner inFile;
	private int lots, numFarmers, price, revenue;
	private int[] pay;

	public static void main(String[] args){
		auction a = new auction();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "auction.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			lots = inFile.nextInt();
			numFarmers = inFile.nextInt();
		}
		pay = new int[numFarmers];
		for(int i = 0; i < numFarmers; i++){
			pay[i] = inFile.nextInt();
		}

		//find max in pay[]
		int max = 0;
		for(int j = 0; j < pay.length; j++){
			if(pay[j] > max){
				max = pay[j];
			}
		}
		int min = max;
		for(int j = 0; j < pay.length; j++){
			if(pay[j] < min){
				min = pay[j];
			}
		}

		//determine the max revenue
		int temp;
		//rev = new int[max];//revenue at each price point. price is the index + 1
		for(int x = 0; x < numFarmers; x++){//go through all possible prices and calculate the revenue received. i is price paid - 1
			int i = pay[x] - 1;

			int rev = 0;
			//rev[i] = 0;
			temp = lots;
			for(int j = 0; j < numFarmers; j++){//go through all the farmers. j is index of farmer
				if(pay[j] >= i + 1 && temp > 0){
					rev += i + 1;
					temp--;
				}
			}
			//System.out.println(i + 1 + " " + rev[i]);

			if(rev > revenue){
				price = i + 1;
				revenue = rev;
			}

			
		}
		//System.out.println(price + "" + revenue);

		//print to file
		try {
		  outFile = new PrintWriter(new File("auction.out"));
		} catch (IOException e) {
		  
		}
		//outFile.println (numPlayed);
		outFile.println(price + " " + revenue);
		outFile.close();
	}
}