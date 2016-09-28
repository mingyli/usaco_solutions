import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;
import java.io.FileNotFoundException;

public class greetings{
	private PrintWriter outFile;
	private Scanner inFile;
	private int numB, numE;//the number of lines to read
	private int bpos = 0, epos = 0;
	private int[] bessie, elsie;
	ArrayList<Integer> bmove = new ArrayList<Integer>();
	ArrayList<Integer> emove = new ArrayList<Integer>();
	private int time = 0;

	public static void main(String[] args){
		greetings a = new greetings();
		a.Run();
	}

	public void Run(){
		//get file contents
		try{
			inFile = new Scanner(new File("greetings.in"));
		}
		catch(FileNotFoundException e){
			//nothing?
		}
		if(inFile.hasNext()){
			numB = inFile.nextInt();
			numE = inFile.nextInt();
			bessie = new int[numB];
			elsie = new int[numE];
			for(int i = 0; i < numB; i++){
				int temp = inFile.nextInt();//steps taken
				String str = inFile.nextLine();//direction
				//System.out.println("." + str + ".") ;
				char ch = str.charAt(1);
				//System.out.println(ch);
				if(ch == 'L') temp = -temp;
				bessie[i] = temp;
			}
			for(int i = 0; i < numE; i++){
				int temp = inFile.nextInt();//steps taken
				String str = inFile.nextLine();//direction
				char ch = str.charAt(1);
				if(ch == 'L') temp = -temp;
				elsie[i] = temp; 
			}
		}

		int maxtime, mintime, btime = 0, etime = 0;
		for(int i = 0; i < bessie.length; i++)
			btime += Math.abs(bessie[i]);
		for(int i = 0; i < elsie.length; i++)
			etime += Math.abs(elsie[i]);
		if(etime > btime){
			maxtime = etime;
			mintime = btime;
		}
		else{
			maxtime = btime;
			mintime = etime;
		}

		//System.out.println(maxtime);

		//System.out.println(bessie[2]);

		for(int b = 0; b < bessie.length; b++){
			for(int i = 0; i < Math.abs(bessie[b]); i++){
				if(bessie[b] > 0)
					bmove.add(1);
				else if(bessie[b] == 0)
					bmove.add(0);
				else bmove.add(-1);
			}
		}
		//System.out.println(bmove.size());

		for(int e = 0; e < elsie.length; e++){
			for(int i = 0; i < Math.abs(elsie[e]); i++){
				if(elsie[e] > 0)
					emove.add(1);
				else if(elsie[e] == 0)
					emove.add(0);
				else emove.add(-1);
			}
		}

		int moos = 0;
		// System.out.println(maxtime);
		for(time = 0; time < maxtime - 1; time++){
			//move bessie
			if(bmove.size() == maxtime || time < bmove.size())
				bpos += bmove.get(time);

			//move elsie
			if(emove.size() == maxtime || time < emove.size())
				epos += emove.get(time);
			//System.out.println(bpos + "    " + epos);


			//if(epos == bpos && bmove.get(time) != emove.get(time)){
			if(epos == bpos){
				moos++;

				if(time <= mintime){
					if(bmove.get(time) == emove.get(time))
						moos--;
				}
			
			}

		}

		//System.out.println(moos);


		//print to file
		try {
		  outFile = new PrintWriter(new File("greetings.out"));
		} catch (IOException e) {
		  
		}
		outFile.println(moos);
		outFile.close();
	}
}