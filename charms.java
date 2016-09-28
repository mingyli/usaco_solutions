import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class charms{
	private PrintWriter outFile;
	private Scanner inFile;
	private int bracelet, numCharms, nail;
	private int[] length, position, ans;

	public static void main(String[] args){
		charms a = new charms();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "charms.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			bracelet = inFile.nextInt();//length of bracelet
			numCharms = inFile.nextInt();
			//System.out.println(numCharms);
			nail = inFile.nextInt();//position of nail
		}
		length = new int[numCharms];
		position = new int[numCharms];
		ans = new int[numCharms];
		for(int i = 0; i < numCharms; i++){
			length[i] = inFile.nextInt();
			//System.out.println(length[i]);
			position[i] = inFile.nextInt();
			ans[i] = 0;//sum of lengths
		}

		// for(int i = 0; i < numCharms; i++){//
		// 	ans[i] = Math.abs(nail - position[i]) + length[i];
		// 	System.out.println(ans[i]);
		// }



		//print to file
		try {
		  outFile = new PrintWriter(new File("charms.out"));
		} catch (IOException e) {
		  
		}
		//outFile.println(ans);
		for(int i = 0; i < numCharms; i++){//
			ans[i] = Math.abs(nail - position[i]) + length[i];
			outFile.println(ans[i]);
		}
		outFile.close();
	}
}