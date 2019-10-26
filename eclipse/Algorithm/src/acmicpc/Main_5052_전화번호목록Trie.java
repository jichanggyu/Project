package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5052_전화번호목록Trie {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= t; tc++) {
			boolean ttf = false;
			int n = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[n];
			String srr[] = new String[n];
			trie ttt = new trie();
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine().trim());
			}
			Arrays.sort(arr);
			for (int i = 0; i < srr.length; i++) {
				srr[i] = ""+arr[i];
			}
			for (int i = 0; i < n; i++) {
				boolean tf = ttt.insert(srr[i], i+1);
				if(!tf) {
					ttf = true;
				}
			}
			
			if(ttf)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		
	}
	
	static class trie{
		trie_node root;

		public trie() {
			this.root = new trie_node("");
		}
		
		boolean insert(String key, int value) {
			trie_node temp = root;
			for(int i = 0 ; i < key.length(); i++) {
				char c = key.charAt(i);
				int asc = c - '0';
				if(temp.leaf) {
					return false;
				}
				if(temp.get(asc)==null) {
					trie_node tn = new trie_node(String.valueOf(c));
					temp.set(value, tn, asc);
					temp = tn;
				}else {
					
					temp = temp.get(asc);
				}

				if(temp.leaf) {
					return false;
				}
			}
			temp.leaf=true;
			return true;
		}
		
		boolean search(String key) {
			trie_node tn = root;
			
			for(int i = 0 ; i <key.length(); i++) {
				int id = Integer.valueOf(key.charAt(i));
				if(tn.get(id) == null) {
					return false;
				}else {
					tn = tn.get(id);
				}
			}
			
			return true;
		}
	}
	
	static class trie_node{
		String character;
		int value;
		boolean leaf;
		trie_node[] idx;
		public trie_node(String character) {
			this.character = character;
			this.idx = new trie_node[10];
		}
		
		
		trie_node get(int index) {
			return idx[index];
		}
		
		void set(int value, trie_node tn, int index) {
			tn.value = value;
			this.idx[index] = tn;
		}
	}
}
