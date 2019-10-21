package programmers;

public class process {
	public static void main(String[] args) {
		Trie test = new Trie();
		
		test.insert("answer", 1);
		test.insert("any", 2);
		test.insert("anomy", 3);
		
		
		System.out.println(test.search("answer"));
		System.out.println(test.search("answerd"));
		System.out.println(test.search("any"));
		System.out.println(test.search("anomy"));
		System.out.println(test.search("anomyy"));
		
	}
}
