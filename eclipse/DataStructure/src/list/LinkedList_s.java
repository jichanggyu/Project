package list;
/* https://opentutorials.org/module/1335/8857
 * 
 * ----------------LinkedList
 * How each node is connected in a line with its data and pointer
 * 
 * 1. Important thing is node
 * 2. java is OOP language
 * 3. head = First node assign reference value
 * 4. so when a node is changed, this value is modified
 * 5. tail = Last node
 * 6. size = node size..
 * 7. The node has data and next variable
 * 8. 
 * 
 */
public class LinkedList_s {
	public static void main(String[] args) {
		
		
	}// end of main
	
	static class LinkeList{
		private Node head;
		private Node tail;
		private int size = 0;
		
		private class Node{
			private Object data; // data field
			private Node next; // next node field
			
			public Node(Object input) {
				this.data = input;
				this.next = null;
			}
			
			// show node data
			public String toString() {
				return String.valueOf(this.data);
			}
			
			
		}
		
		Node node(int index) {
			Node x = head;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		}
		
		void addFirst(Object input) {
			Node newNode = new Node(input);
			newNode.next = head;
			head = newNode;
			size++;
			
			if(head.next == null) {
				tail = head;
			}
		}
		
		void addLast(Object input) {
			Node newNode = new Node(input);
			if(size == 0) {
				addFirst(input);
			} else {
				newNode.next = tail;
				tail = newNode;
				size++;
			}
		}
		
		void add(int k, Object input) {
			if( k == 0 ) {
				addFirst(input);
			}
			else {
				Node temp1 = node(k-1);
				Node temp2 = temp1.next;
				Node newNode = new Node(input);
				temp1.next = newNode;
				newNode.next = temp2;
				size++;
				
				if(newNode.next==null) {
					tail = newNode;
				}
			}
		}
		
		Object removeFirst() {
			Node newNode = head;
			head = head.next;
			
			Object tmp = newNode.data;
			newNode = null;
			size--;
			
			return tmp;
		}
	}
}// end of class
