package programmers;

public class Trie {
	private Node root;
	private int indexOfStringChild; // 단일 노드의 인덱스 
	public Trie() {
		this.root = new Node("");
	}
	
	void insert(String key, int value) {
		Node tempNode = root;
		
		for(int i = 0 ; i < key.length(); i++) {
			char c = key.charAt(i);
			int asc = c-'a';
			
			if(tempNode.getChild(asc) == null) {
				Node node = new Node(String.valueOf(c));
				tempNode.setChild(asc, node, value);
				tempNode = node;
			}else 
				tempNode = tempNode.getChild(asc);
		}
		tempNode.setLeaf(true);
	}
	
	public boolean search(String key) {
		Node trieNode = root;
		
		for(int i = 0 ; i < key.length(); i++) {
			int asc = key.charAt(i) - 'a';
			
			if(trieNode.getChild(asc) == null) {
				return false;
			}else {
				trieNode = trieNode.getChild(asc);
			}
		}
		
		return true;
	}
}

class Node {
	private String character;
	private int value;
	private Node[] children;
	private boolean leaf;
	
	Node(String character) {
		this.character = character;
		this.children = new Node[26];
	}
	
	public Node getChild(int index) {
		return children[index];
	}
	
	public void setChild(int index, Node node, int value) {
		node.setValue(value);
		this.children[index] = node;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
}