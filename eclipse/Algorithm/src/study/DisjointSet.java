package study;

import java.io.*;
import java.util.*;

/*  Union-FInd ¿¬»ê
 * 
 *  1. make-set(x)
 *  2. union(x,y)
 *  3. find(x)
 *  
 * 
 */

public class DisjointSet {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine().trim());
		int P = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[G + 1];

		for (int i = 1; i < arr.length; i++)
			arr[i] = i;
		
		for(int i = 0; i < P ; i++) {
			int join = Integer.parseInt(br.readLine().trim());
			
		}
	}// end of main
	
	static int Find(int[] arr, int idx) {
		if(arr[idx] == idx) {
			return idx;
		}
		else
			return Find(arr,arr[idx]);
	}
	
	
	static void union(int[] arr, int a, int b) {
		a = Find(arr, a);
		b = Find(arr, b);
		
		if(a < b) {
			arr[b] = a;
		}
		else
			arr[a] = b;
	}
}// end of class






