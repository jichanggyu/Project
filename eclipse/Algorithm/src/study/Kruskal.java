package study;

/*
 * 1. 일단 처음에는 가중치 기준으로 소트를 시킨다.
 * 2. 작은 것부터 한개씩 넣으면 되는데 여기서 Union - Find 를 사용하여 사이클이 생기는걸 방지시켜준다
 * 
 * 
 * -- 구현해야할 것
 * 
 * 1. Union method
 * 2. Find method
 * 3. Sort ( Quick 으로 해보자 )
 */
import java.util.*;
import java.io.*;

public class Kruskal {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		data[] connect = new data[M];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			connect[i] = new data(a, b, w);
		}

		quickSort(connect, 0, M - 1);
		int[] idx = new int[N+1];
		for(int i = 0; i < idx.length ; i++) {
			idx[i] = i;
		}
		int result = 0;
		for(int i = 0 ; i < M ; i++) {
			data temp = connect[i];
			int a = temp.a;
			int b = temp.b;
			int w = temp.w;
			if(Find(idx,a) != Find(idx,b)) {
				Union(idx,a,b);
				result += w;
			}
		}
		System.out.println(result);

	}// end of main

	static void quickSort(data[] arr, int begin, int end) {
		if (begin < end) {
			int p = partition(arr, begin, end);
			quickSort(arr, begin, p - 1);
			quickSort(arr, p + 1, end);
		}
	}

	static int partition(data[] arr, int begin, int end) {
		int pivot, L, R;
		data temp;
		L = begin;
		R = end;
		pivot = (L + R) / 2;
		while (L < R) {
			while (arr[L].w <= arr[pivot].w && (L <= R))
				L++;
			while (arr[R].w > arr[pivot].w && (L <= R))
				R--;

			if (L <= R) {
				temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
				if (R == pivot) {
					return L;
				}
			}
		}

		temp = arr[pivot];
		arr[pivot] = arr[R];
		arr[R] = temp;
		return R;
	}

	static void Union(int[] arr, int a, int b) {
		a = Find(arr, a);
		b = Find(arr, b);

		if (a < b)
			arr[b] = a;
		else
			arr[a] = b;
	}

	static int Find(int[] arr, int idx) {
		if (arr[idx] == idx)
			return idx;
		else
			return arr[idx] = Find(arr, arr[idx]);
	}

	static class data {
		int a;
		int b;
		int w;

		public data(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}// end of data class
}// end of class
