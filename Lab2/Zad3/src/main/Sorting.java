package main;

public class Sorting {
	int c, d, swap;
    

    int[] table;
 
    public int[] sort()
    {
	    for (c = 0; c < ( table.length - 1 ); c++) {
	      for (d = 0; d < table.length - c - 1; d++) {
	        if (table[d] > table[d+1])
	        {
	          swap       = table[d];
	          table[d]   = table[d+1];
	          table[d+1] = swap;
	        }
	      }
	    }
	 return table;
    }
    
    public void setTable(int[] array)
    {
    	table = array;
    }

   
}