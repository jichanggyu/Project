package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] array = new int[N];
		int[] dp = new int[N];
		
		int max = 0;
		dp[0] = 1;
		
		for(int i = 0 ; i < N ; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(array[i] > array[j] && dp[j]+1>dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
			if(max < dp[i]) {
				max = dp[i];
			}
		}// end of for
		
		
	}// end of main
}// end of class
