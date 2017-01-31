import java.io.*;
import java.util.*;

public class LCS {
public static void main(String args[]) throws Exception {
	String filepath1 = args[0];
	String filepath2 = args[1];
	String filepath3 = args[2];
	BufferedReader br1=new BufferedReader(new FileReader(filepath1));
	BufferedReader br2=new BufferedReader(new FileReader(filepath2));
	BufferedReader br3=new BufferedReader(new FileReader(filepath3));
	
	File out = new File("lcs_out.txt");
        FileWriter fw = null;
		fw = new FileWriter(out);
		BufferedWriter writer = new BufferedWriter(fw);
		
    String line1 = null;
	String line2 = null;
	String line3 = null;
	int x=0, y=0, z=0;
	int u=0, v=0, w=0;
	
	while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null) {    //Reading from the input file
      String[] values1 = line1.split(",");
	  String[] values2 = line2.split(",");
	  String[] values3 = line3.split(",");
	  x=values1.length;
	  y=values2.length;
      z=values3.length;	  
	  int[] input1=new int[x];
	  int[] input2=new int[y];
	  int[] input3=new int[z];
					
      for(String str1 : values1) {
       	input1[u]=Integer.parseInt(str1);  
				u++;
      } 
	  
	  for(String str2 : values2) {
       	input2[v]=Integer.parseInt(str2);  
				v++;
      } 
	  
	  for(String str3 : values3) {
       	input3[w]=Integer.parseInt(str3);   
				w++;
      } 
			String s = ((Integer)lcs(input1, input2, input3)).toString();
			System.out.println("Output is written to file lcs_out.txt");
			writer.write("The longest common subsequence among the three files is ");
			writer.write(s);
}	
	br1.close();
	br2.close();
	br3.close();
writer.flush();
writer.close();
}

private static int lcs(final int[] a, final int[] b, final int[] c) {
    return recursive_lcs(a, b, c, "0");
}

private static int recursive_lcs(final int[] a, final int[] b, final int[] c, String res) {
    
    if ((a.length == 0) || (b.length == 0) || (c.length == 0)) { //If one of the string is empty
        return Integer.parseInt(res);
    }
    else if ((a[0] == b[0]) && (b[0] == c[0])) {
        res += ((Integer)a[0]).toString();
        final int r1 = recursive_lcs(getSubString(a,1), getSubString(b,1),
                getSubString(c,1), res);
        
        final int r2 = findMax(a, b, c, "0"); // Searching for a longest sequence 

        if (r2 > r1) {
            return r2;
        } else {
            return r1;
        }
    }
    else {
        final int c1 = findMax(a, b, c, "0");
        if (c1 > res.length()) {
            return c1;
        } else {
            return Integer.parseInt(res);
        }
    }
}

private static int[] getSubString(int[] a,int i) {
	int[] b=new int[a.length-1];
	for(int j=i;j<a.length;j++)
		b[j-1]=a[j];
	return b;
}

private static int findMax(final int[] a, final int[] b, final int[] c, final String res) {
    
    final String c1 = ((Integer)recursive_lcs(a, b, getSubString(c,1), res)).toString();
    final String c2 = ((Integer)recursive_lcs(a, getSubString(b,1), c, res)).toString();
    final String c3 = ((Integer)recursive_lcs(getSubString(a,1), b, c, res)).toString();
    if (c1.length() > c2.length()) {
        if (c1.length() > c3.length()) {
            return Integer.parseInt(c1);
        } else {
            return Integer.parseInt(c3);
        }
    } else {
        if (c2.length() > c3.length()) {
            return Integer.parseInt(c2);
        } else {
            return Integer.parseInt(c3);
        }
    }
}
}
