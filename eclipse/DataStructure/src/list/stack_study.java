package list;

/* stack ?? 
 * 1. LIFO
 * 2. Push, Pop, Peek
 * 3. use 2 type stack 
 *    a. array_list
 *    b. linked_list
 *    
 *    
 * 구현 하는 순서
 * 1. 처음 일단 stack의 객체를 생성해야함
 * 2. 객체를 생성하여 생성자를 만든다.
 * 3. push pop peek를 구현한다
 * 4. 테스트를 해본다.
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
		
		// 3 3 2 2 1 1 순으로 나오면 됨
	}// end of main
	
	static int size = 20;
	static class stack_study_class{
		// 객체의 필요한 것은 
		// 인덱스를 관리해주는 변수
		// 저장하는 어레이
		int top;
		Object[] stackArray;
		
		//생성자 
		public stack_study_class() {
			stackArray = new Object[size];
			top = -1;
		}
		// 생성자가 실행되면 인덱스 top는 -1로 해줌
		
		// 이제 Push, Pop, peek을 구현하면 끝
		// Arraylist로 구현하기 때문에 사이즈가 넘어가면 복사해서 사이즈를 2배만큼 키워주기
		// 저번주에 했으니 여기서는 그냥 그런 예외처리는 안함
		
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
