import java.io.*;
import java.util.*;

public class Bubblesort {
static int input[];
	
public static void main(String[] args) throws Exception {
	long startTime = System.currentTimeMillis();
    String filepath = args[0];
	BufferedReader br=new BufferedReader(new FileReader(filepath));
    String line = null;
	int n=0;
	int i=0;
		
  File file=new File("Bubblesort_out.txt");  //Creating an output file
  file.createNewFile();
  FileWriter writer=new FileWriter(file);
  
	while ((line = br.readLine()) != null) {   //Reading from the input file
      String[] values = line.split(",");
	  n=values.length; 
	  int[] input=new int[n];
					
      for(String str : values) {
       	input[i]=Integer.parseInt(str); //Parsing string to Integer
				i++;
      }
	  int a, b, swap;
	     for(a = 0; a < ( n - 1 ); a++) {
            for (b = 0; b < n - a - 1; b++) {
               if(input[b] > input[b+1]) 
                {
					swap = input[b];
					input[b] = input[b+1];
					input[b+1] = swap;
				}
			}
		}
    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;   //Calculating the run time of the program
    writer.write("The size of the input is " + n + " and the total running time is " + totalTime + " milli seconds");
	writer.write("\r\n");
    writer.write("\nElements after sorting are:  ");
	writer.write("\r\n");
       for(int k=0;k<n;k++)
           writer.write(input[k]+" ");     //Writing data into output file     
 }
br.close();
System.out.println("The output is written to the file Bubblesort_out.txt");
writer.flush();
writer.close(); 
  }
}