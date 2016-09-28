import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class sub{
	private PrintWriter outFile;
	private Scanner inFile;
	private int l1, l2;
	private String s1 = "", s2 = "";

	public static void main(String[] args){
		sub a = new sub();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "sub.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			l1 = inFile.nextInt();
			l2 = inFile.nextInt();
		}
		// s1 = new int[l1];
		// s2 = new int[l2];
		for(int i = 0; i < l1; i++){
			s1 += inFile.nextInt() + " ";
			//System.out.println(s1[i]);
		}
		for(int i = 0; i < l2; i++){
			s2 += inFile.nextInt() + " ";
			// System.out.println(s2[i]);
		}

		// System.out.println(s1);
		// System.out.println(s2);
		int max = 0;
		for(int i = 0; i < s1.length(); i++){
			for(int j = i; j < s1.length(); j++){
				String temp = s1.substring(i, j);
				if(s2.contains(temp) && temp.length() / 2 > max){
					max = temp.length() / 2;
				}
			}
		}

		//System.out.println(max);

		//print to file
		try {
		  outFile = new PrintWriter(new File("sub.out"));
		} catch (IOException e) {
		  
		}
		outFile.println(max);
		outFile.close();
	}
}