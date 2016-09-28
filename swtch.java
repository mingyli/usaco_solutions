import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class swtch{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numLights, numOper;
	private int[] oper, start, end;
	private boolean[] lights;

	public static void main(String[] args){
		swtch a = new swtch();
		a.Run();
	}

	public void Run(){
		//get file contents
		try{
			inFile = new Scanner(new File("swtch.in"));
			outFile = new PrintWriter(new File("swtch.out"));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numLights = inFile.nextInt();
			numOper = inFile.nextInt();
			oper = new int[numOper];
			start = new int[numOper];
			end = new int[numOper];
			lights = new boolean[numLights];
			for(int i = 0; i < numOper; i++){
				oper[i] = inFile.nextInt();
				start[i] = inFile.nextInt();
				end[i] = inFile.nextInt();
			}
		}

		for(int i = 0; i < numLights; i++){
			lights[i] = false;
		}

		for(int i = 0; i < numOper; i++){
			if(oper[i] == 1){//ask cows to count how many lights are on. print this to file
				int count = 0;
				for(int a = start[i]; a <= end[i]; a++){
					if(lights[a - 1]) count++;
				}
				outFile.println(count);
			}
			else{//flip the light switches
				for(int a = start[i]; a <= end[i]; a++){
					lights[a - 1] = !lights[a - 1];
				}
			}
		}


		//print to file
		// try {
		//   //outFile = new PrintWriter(new File("swtch.out"));
		// } catch (IOException e) {
		  
		// }
		outFile.close();
	}
}