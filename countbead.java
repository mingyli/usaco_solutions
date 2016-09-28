import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class countbead{
	private int blue = 1, orange = 0;
	private PrintWriter outFile;
	private Scanner inFile;
	private int numBeads;
	private int answer = 0;

	public static void main(String[] args){
		countbead c = new countbead();
		c.Run();
	}

	public void Run(){
		String inputFile = "countbead.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numBeads = inFile.nextInt();
			//System.out.println(numBeads);
		}
		boolean[] bead = new boolean[numBeads];//true is blue, false is orange
		int count = 0;
		while(inFile.hasNext()){
			int temp = inFile.nextInt();
			if(temp == 0)
				bead[count] = false;
			else
				bead[count] = true;
			count++;
		}

		for(int i = 0; i < numBeads - 1; i++){
			if(bead[i] != bead[i + 1]){
				answer++;
			}
		}
		//System.out.print(answer);

		try {
		  outFile = new PrintWriter(new File("countbead.out"));
		} catch (IOException e) {
		  
		}
		//System.out.print(answer);
		outFile.println(answer);
		outFile.close();
	}
}