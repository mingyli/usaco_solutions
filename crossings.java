import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class crossings{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numCows;
	private int[] x1, x2;

	public static void main(String[] args){
		crossings a = new crossings();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "crossings.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numCows = inFile.nextInt();
			x1 = new int[numCows];
			x2 = new int[numCows];
			for(int i = 0; i < numCows; i++){
				x1[i] = inFile.nextInt();
				x2[i] = inFile.nextInt();
			}
		}

		int ans = 0;

		for(int i = 0; i < numCows; i++){//go through all the cows
			boolean yes = true;
			for(int j = i; j < numCows; j++){//
				if(intersects(x1[i], x2[i], x1[j], x2[j])){
					yes = false;
					
				}
				
			}
			if(yes) ans++;
		}
		

		System.out.println(ans);

		System.out.println(intersects(-3, 4, 7, 8));



		//print to file
		try {
		  outFile = new PrintWriter(new File("crossings.out"));
		} catch (IOException e) {
		  
		}
		outFile.println(ans);
		outFile.close();
	}

	public static boolean intersects(int x1, int x2, int x3, int x4){
		// int temp;
		// if(x1 > x2){
		// 	temp = x1;//swap they nigs
		// 	x1 = x2;
		// 	x2 = temp;
		// }
		// if(x3 > x4){
		// 	temp = x3;
		// 	x3 = x4;
		// 	x4 = temp;
		// }

		if(x1 < x3){
			if(x2 < x4) return false;
			else return true;
		}
		else{
			if(x2 < x4) return true;
			else return false;
		}
	}
}