package list;

/*
 * queue
 * 1. FIFO
 * 2. add, remove, peek
 * 
 */

public class queue_study {
	public static void main(String[] args) {
		queue_study_class test = new queue_study_class();
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		System.out.println(test.peek());
		System.out.println(test.remove());
		System.out.println(test.peek());
		System.out.println(test.remove());
		System.out.println(test.peek());
		System.out.println(test.remove());
	}// end of main
	
	static int size = 100;
	// using linked_list
	// make node class
	
	static class queue_study_class{
		
		//--------------------------------------------------------------
		class node{
			Object data;
			node next;
			
			public node(Object data) {
				this.data = data;
			}
		}
		//-------------------------------------------------------------
		
		node last;
		node first;
		
		void add(Object data) {
			node tmp = new node(data);
			if(last == null || first == null) { // reset..
				last = tmp;
				first = tmp;
			}
			last.next = tmp;
			last = tmp;
		}// end of add
		
		Object remove() { // terminate first value of list
			node tmp = first;
			first = first.next;
			return tmp.data;
		}// end of remove
		
		Object peek() { // return top value of list
			
			return first.data;
		}// end of peek
		
	}
	
	
}// end of class
