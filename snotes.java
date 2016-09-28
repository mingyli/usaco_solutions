import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class snotes{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numNotes, numQuestions, length;//length of song
	private int[] duration, questions, ans, song;

	public static void main(String[] args){
		snotes s = new snotes();
		s.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "snotes.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numNotes = inFile.nextInt();
			numQuestions = inFile.nextInt();
			//System.out.println(numQuestions);
		}
		length = 0;
		duration = new int[numNotes];
		ans = new int[numQuestions];
		questions = new int[numQuestions];
		for(int i = 0; i < numNotes; i++){
			duration[i] = inFile.nextInt();
			length += duration[i];
		}
		//System.out.println(length);
		for(int i = 0; i < numQuestions; i++){
			questions[i] = inFile.nextInt();
		}
		song = new int[length];
		for(int i = 0; i < length; i++){
			song[i] = 0;
		}

		// System.out.println(duration[2]);
		int currentTime = 0;
		for(int i = 1; i <= numNotes; i++){//i is the note
			for(int t = 0; t < duration[i - 1]; t++){
				song[currentTime] = i;
				currentTime++;
			}
		}

		// for(int i = 0; i < length; i++)
		// 	System.out.println(i + "    " + song[i]);
		for(int i = 0; i < numQuestions; i++){
			ans[i] = song[questions[i]];
		}

		//print to file
		try {
		  outFile = new PrintWriter(new File("snotes.out"));
		} catch (IOException e) {
		  
		}
		for(int i = 0; i < numQuestions; i++){
			outFile.println(ans[i]);
		}
		outFile.close();
	}
}