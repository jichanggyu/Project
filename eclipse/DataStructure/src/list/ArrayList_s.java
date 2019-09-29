package list;

/* ---------------------ArrayList 
 * use nearly 8 type
 * 1. construct
 * 2. add
 * 3. add at position
 * 4. contains
 * 5. size
 * 6. isEmpty
 * 7. get
 * 8. remove
 * 
 * https://blog.ilkyu.kr/entry/%EB%A6%AC%EC%8A%A4%ED%8A%B8-List-1-ArrayList-%EA%B5%AC%ED%98%84
 */

public class ArrayList_s {
	public static void main(String[] args) {
		ArrayList_study al = new ArrayList_study();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(7);
		al.add(8);
		al.add(9);
		al.add(10);
		al.add(11);
		al.add(12);
		al.add(13);
		al.size();
		al.get(3);
		al.get(4);
		al.get(5);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.remove(1);
		al.get(1);
	}// end of main

	private static int[] list;
	private static int size;
	private static int index = 10;

	static class ArrayList_study {
		public ArrayList_study() {
			list = new int[index];
			size = 0;
		}

		void add(int value) {
			if (size == list.length) {
				int[] tmp = new int[index * 2];
				for (int i = 0; i < list.length; i++) {
					tmp[i] = list[i];
				}
				list = tmp;
				list[size++] = value;
			}

			else
				list[size++] = value;
			
			System.out.println(value+"를 "+(size-1)+"인덱스에 저장하였습니다." );
		}// end of add method

		int size() {
			System.out.println(size+"사이즈를 가지고 있습니다.");
			return size;
		}

		int get(int index) {
			System.out.println(index+"의 인덱스는 "+list[index]+"값을 가지고 있습니다.");
			return list[index];
		}

		void remove(int index) {
			System.out.println(list[index]+"의 값이 삭제되었습니다.");
			for (int i = index; i < size; i++) {
				list[i] = list[i + 1];
			}
		}
	}// end of class(ArrayList)

}// end of class
