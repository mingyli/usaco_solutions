import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class proximity{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numCows, crowd;
	//private int[] breed;
	private cow[] cow;

	public static void main(String[] args){
		proximity a = new proximity();
		a.Run();
	}

	public void Run(){
		//get file contents
		String inputFile = "proximity.in";
		try{
			inFile = new Scanner(new File(inputFile));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numCows = inFile.nextInt();
			crowd = inFile.nextInt();
			// breed = new int[numCows];
			cow = new cow[numCows];
			for(int i = 0; i < numCows; i++){
				//breed[i] = inFile.nextInt();
				cow[i] = new cow(inFile.nextInt(), i);
			}

		}

		//BubbleSort(cow);
		Arrays.sort(cow);

		int max = 0;

		for(int i = 0; i < numCows - 1; i++){
			if(cow[i].breed == cow[i + 1].breed){
				int dist = Math.abs(cow[i].location - cow[i+1].location);
				if(dist <= crowd){
					if(cow[i].breed > max)
						max = cow[i].breed;
				}
			}
		}



		//print to file
		try {
		  outFile = new PrintWriter(new File("proximity.out"));
		} catch (IOException e) {
		  
		}
		outFile.println(max);
		System.out.println(max);
		outFile.close();
	}

	public static void BubbleSort( cow [ ] num )
	{
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     cow temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < num.length -1;  j++ )
	            {
	                   if ( num[ j ].breed < num[j+1].breed )   // change to > for ascending sort
	                   {
	                           temp = num[ j ];                //swap elements
	                           num[ j ] = num[ j+1 ];
	                           num[ j+1 ] = temp;
	                          flag = true;              //shows a swap occurred 
	                  }
	            }
	      }
	} 
}

class cow implements Comparable<cow>{
	int breed, location;

	public cow(int br, int loc){
		breed = br;
		location = loc;
	}

	@Override
	public int compareTo(cow c){
		return c.breed - this.breed;
	}
}