import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class rplow{
	private PrintWriter outFile;
	private Scanner inFile;
	private int width, height, numInstr;
	private boolean[][] field;

	public static void main(String[] args){
		rplow r = new rplow();
		r.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "rplow.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			width = inFile.nextInt();
			height = inFile.nextInt();
			numInstr = inFile.nextInt();
		}
		field = new boolean[height][width];
		for(int r = 0; r < height; r++){
			for(int c = 0; c < width; c++){
				field[r][c] = false;
			}
		}

		for(int i = 0; i < numInstr; i++){
			int x1 = inFile.nextInt();
			int y1 = inFile.nextInt();//lower left
			int x2 = inFile.nextInt();
			int y2 = inFile.nextInt();//upper right
			for(int r = y1; r <= y2; r++){
				for(int c = x1; c <= x2; c++){
					field[r - 1][c - 1] = true;
				}
			}
		}
		
		int ans = 0;
		for(int r = 0; r < height; r++){
			for(int c = 0; c < width; c++){
				if(field[r][c]){
					//System.out.print('*');
					ans++;
				}
				//else System.out.print('.');
			}
			//System.out.println();
		}

		//System.out.println(ans);

		//print to file
		try {
		  outFile = new PrintWriter(new File("rplow.out"));
		} catch (IOException e) {
		  
		}
		outFile.println(ans);
		outFile.close();

	}
}