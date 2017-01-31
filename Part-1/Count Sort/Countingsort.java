import java.io.*;
import java.util.*;

public class Countingsort {
	static int input[];
    private static final int MAX_RANGE = 1000000;
    	
    public static void sort( int[] array )  // Counting Sort function 
    {
        int N = array.length;
        if (N == 0)
            return;
        
        int max = array[0], min = array[0]; // max and min values 
        for (int i = 1; i < N; i++)
        {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        int range = max - min + 1;
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return;
        }
 
        int[] count = new int[range];
        for (int i = 0; i < N; i++)   //count array for each element 
            count[array[i] - min]++;
        for (int i = 1; i < range; i++)  //positions in final array 
            count[i] += count[i - 1];
        
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                array[j++] = i + min;
    }
	
public static void main(String[] args) throws Exception {
	long startTime = System.currentTimeMillis();
    String filepath = args[0];
	BufferedReader br=new BufferedReader(new FileReader(filepath));
    String line = null;
	int n=0;
	int i=0;
	
    File file=new File("Countingsort_out.txt");   //Creating an output file
    file.createNewFile();
    FileWriter writer=new FileWriter(file);	
  
    while ((line = br.readLine()) != null) {    //Reading from the input file
      String[] values = line.split(",");
	  n=values.length; 
	  int[] input=new int[n];
					
      for(String str : values) {
       	input[i]=Integer.parseInt(str);   //Parsing string to Integer
				i++;
      } 
      sort(input);
	  
	long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;   //Calculating the run time of the program
    writer.write("The size of the input is " + n + " and the total running time is " + totalTime + " milli seconds");
	writer.write("\r\n");
    writer.write("\nElements after sorting are:  ");
	writer.write("\r\n");
	    for(i=0; i<n; i++)
            writer.write(input[i]+" "); //Writing data into output file        
 }
br.close();
System.out.println("The output is written to the file Countingsort_out.txt");
writer.flush();
writer.close(); 
 }
}
   
    