import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class paint2{
	private PrintWriter outFile;
	private Scanner inFile;
	private int side, numLocations;
	private int[] xpos, ypos;

	public static void main(String[] args){
		paint2 a = new paint2();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "paint2.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			side = inFile.nextInt();
			numLocations = inFile.nextInt();
		}
		xpos = new int[numLocations];
		ypos = new int[numLocations];
		for(int i = 0; i < xpos.length; i++){
			xpos[i] = inFile.nextInt();
			ypos[i] = inFile.nextInt();
		}

		int ans = 0;
		
		for(int r = 0; r < side; r++){
			for(int c = 0; c < side; c++){
				boolean yes = true;
				for(int i = 0; i < numLocations; i++){
					if(!canShoot(r + 1, c + 1, xpos[i], ypos[i])){
						yes = false;
					}
				}
				if(yes){
					ans++;
					//System.out.println(r + "  " + c);
				}
			}
		}

		//System.out.println(ans);



		//print to file
		try {
		  outFile = new PrintWriter(new File("paint2.out"));
		} catch (IOException e) {
		  
		}
		outFile.println(ans);
		outFile.close();
	}

	public static boolean canShoot(int x, int y, int x2, int y2){
		int a = x - x2, b = y - y2;
		return (a*a*a*b)==(b*b*b*a);
	}
}