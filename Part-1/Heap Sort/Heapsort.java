import java.io.*;
import java.util.*;

public class Heapsort {
    static int input[];
    private static int N;

    public static void sort(int array[]) {   /* Sort Function */
        heapify(array);
        for (int i = N; i > 0; i--) {
            swap(array, 0, i);
            N = N - 1;
            maxheap(array, 0);
        }
    }
    
    public static void heapify(int array[]) {   /* Building a heap */
        N = array.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            maxheap(array, i);
        }
    }

    public static void maxheap(int array[], int i) {   /* Largest element in heap */
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= N && array[left] > array[i]) {
            max = left;
        }
        if (right <= N && array[right] > array[max]) {
            max = right;
        }
        if (max != i) {
            swap(array, i, max);
            maxheap(array, max);
        }
    }

    public static void swap(int array[], int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /* Main method */
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        String filepath = args[0];
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line = null;
        int n = 0;
        int i = 0;
		
     File file=new File("Heapsort_out.txt");  //Creating an output file
     file.createNewFile();
     FileWriter writer=new FileWriter(file);
	 
        while ((line = br.readLine()) != null) {  //Reading from the input file
            String[] values = line.split(",");
            n = values.length;
            int[] input = new int[n];

            for (String str : values) {
                input[i] = Integer.parseInt(str); //Parsing string to Integer
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
System.out.println("The output is written to the file Heapsort_out.txt");
writer.flush();
writer.close(); 
 }
}
    

