import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class rotation{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numPulleys;
	private int[] source, dest, connect;

	public static void main(String[] args){
		rotation a = new rotation();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "rotation.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numPulleys = inFile.nextInt();
			source = dest = connect = new int[numPulleys - 1];
			for(int i = 0; i < numPulleys - 1; i++){
				source[i] = inFile.nextInt();
				dest[i] = inFile.nextInt();
				connect[i] = inFile.nextInt();
			}
		}

		int ans = 0;
		for(int i = 0; i < connect.length; i++){
			ans += connect[i];
		}
		ans = ans % 2;


		//print to file
		try {
		  outFile = new PrintWriter(new File("rotation.out"));
		} catch (IOException e) {
		  
		}
		outFile.println(ans);
		outFile.close();
	}
}