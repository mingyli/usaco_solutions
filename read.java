import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class read{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numCows, numPages;

	public static void main(String[] args){
		read r = new read();
		r.Run();
	}

	public void Run(){
		String inputFile = "read.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numPages = inFile.nextInt();
			numCows = inFile.nextInt();
			//System.out.println(numCows);
		}
		int[] rate = new int[numCows];
		int[] time = new int[numCows];
		int[] rest = new int[numCows];
		int count = 0;
		for(int i = 0; i < numCows; i++){
			rate[i] = inFile.nextInt();
			time[i] = inFile.nextInt();
			rest[i] = inFile.nextInt();
		}

		//System.out.print(time[2]);
		int[] minutes = new int[numCows];
		for(int i = 0; i < numCows; i++)
			minutes[i] = 0;

		int straightread;
		for(int i = 0; i < numCows; i++){
			straightread = numPages / rate[i];//time to read in one sitting
			
			int max = rate[i] * time[i];//max pages read before rest
			int temp = numPages;//number of pages left to read
			//System.out.println(max);
			while(temp > max){
				minutes[i] += time[i] + rest[i];
				//System.out.println("minutes" + minutes[i]);
				temp -= max;
				
			}
			//System.out.println("temp" + temp);
			//System.out.println(Math.ceil(temp / rate[i]));
			minutes[i] += Math.ceil((double)temp / rate[i]);
			//System.out.println(minutes[i]);

		}


		try {
		  outFile = new PrintWriter(new File("read.out"));
		} catch (IOException e) {
		  
		}
		for(int i = 0; i < numCows; i++){
			outFile.println(minutes[i]);
		}
		outFile.close();
	}
}