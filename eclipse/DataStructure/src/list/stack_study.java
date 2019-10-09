package list;

/* stack ?? 
 * 1. LIFO
 * 2. Push, Pop, Peek
 * 3. use 2 type stack 
 *    a. array_list
 *    b. linked_list
 *    
 *    
 * ���� �ϴ� ����
 * 1. ó�� �ϴ� stack�� ��ü�� �����ؾ���
 * 2. ��ü�� �����Ͽ� �����ڸ� �����.
 * 3. push pop peek�� �����Ѵ�
 * 4. �׽�Ʈ�� �غ���.
 */


public class stack_study {
	public static void main(String[] args) {
		stack_study_class test = new stack_study_class();
		
		test.Push(1);
		test.Push(2);
		test.Push(3);
		
		System.out.println(test.peek());
		System.out.println(test.Pop());
		System.out.println(test.peek());
		System.out.println(test.Pop());
		System.out.println(test.peek());
		System.out.println(test.Pop());
		
		// 3 3 2 2 1 1 ������ ������ ��
	}// end of main
	
	static int size = 20;
	static class stack_study_class{
		// ��ü�� �ʿ��� ���� 
		// �ε����� �������ִ� ����
		// �����ϴ� ���
		int top;
		Object[] stackArray;
		
		//������ 
		public stack_study_class() {
			stackArray = new Object[size];
			top = -1;
		}
		// �����ڰ� ����Ǹ� �ε��� top�� -1�� ����
		
		// ���� Push, Pop, peek�� �����ϸ� ��
		// Arraylist�� �����ϱ� ������ ����� �Ѿ�� �����ؼ� ����� 2�踸ŭ Ű���ֱ�
		// �����ֿ� ������ ���⼭�� �׳� �׷� ����ó���� ����
		
		// Push
		void Push(Object value) {
			stackArray[++top] = value;
		}// end of Push
		
		Object Pop() {
			return stackArray[top--];
		}// end of pop
		
		Object peek() {
			return stackArray[top];
		}
	}
	
	
	
}// end of class
