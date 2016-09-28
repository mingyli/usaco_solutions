import java.io.*;
import java.util.*;

public class stroll{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numRows, numCols;
	private char[][] matrix;
	private long[][] way;

	public static void main(String[] args){
		stroll a = new stroll();
		a.Run();
	}

	public void Run(){
		//get file contents
		try{
			inFile = new Scanner(new File("stroll.in"));
			outFile = new PrintWriter(new File("stroll.out"));
		}catch(FileNotFoundException e){}
		numRows = inFile.nextInt();
		numCols = inFile.nextInt();
		matrix = new char[numRows][numCols];
		way = new long[numRows][numCols];
		String trash = inFile.nextLine();
		for(int i = 0; i < numRows; i++){
			String temp = inFile.nextLine();
			for(int j = 0; j < numCols; j++){
				matrix[i][j] = temp.charAt(j * 2);
				way[i][j] = 1;
			}
		}

		int rans = 0, cans = 0;
		boolean firstB = true;
		for(int r = 0; r < numRows; r++){
			for(int c = 0; c < numCols; c++){
				
				if(matrix[r][c] == 'B'){
					if(firstB){
						way[r][c] = 1;
						firstB = false;
					}
					else{
						rans = r;
						cans = c;
					}
				}


				if(matrix[r][c] == 'R')
					way[r][c] = 0;
				else if(r == 0 && c == 0){
					// way[r][c] = 1;
				}
				else if(r == 0)//top row
					way[r][c] = way[r][c - 1];
				else if(c == 0)
					way[r][c] = way[r - 1][c];
				else
					way[r][c] = way[r - 1][c] + way[r][c - 1];
			}
		}

		// for(int r = 0; r < numRows; r++){
		// 	for(int c = 0; c < numCols; c++){
		// 		System.out.print(way[r][c] + " ");
		// 	}
		// 	System.out.println();
		// }

		outFile.println(way[rans][cans]);
		outFile.close();
	}
}