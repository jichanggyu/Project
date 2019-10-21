package programmers;

public class programmers {
	public static void main(String[] args) {
		B obj = new B();
		System.out.println(obj.x);
		
		A obj2 = new B();
		System.out.println(obj2.A());
	}
}

class A{
	int x = 3;
	
	 String A() {
		return "기문";
				
	}
	
}

class B extends A{
	int y = 4;
	 String A() {
		return "송해";
	}
	
}