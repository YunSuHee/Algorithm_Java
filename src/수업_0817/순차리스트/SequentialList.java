package 수업_0817.순차리스트;

import java.util.Arrays;

public class SequentialList {
	// 문자열을 관리를 하겠다.
	private String[] arr;
	private int size; // 현재 배열에 차있는 데이터의 갯수

	public SequentialList() {
		// 생성자를 통해서 초기화를 하겠다.
		this.arr = new String[10];
		this.size = 0;
	}

	// 조회 기능
	public String get(int idx) {
		// 사용자를 신뢰할수 없기 떄문에 조건을 걸어서 제한하겠다.
		if (idx < 0 || idx >= size)
			return null; // 예외를 발생시킬 수도 있겠네요?
		// 해당 idx번째의 값을 가져와
		return arr[idx];
	}

	// 첫번째 삽입
	public void addFirst(String data) {
		//넣을 수있는지?
		if(size == arr.length)
			return; //예외처리를 할 수 있겠다.

		// 뒤에서 부터 하나씩 밀고 나서 데이터를 넣어야한다.
		for (int i = size - 1; i >= 0; i--)
			arr[i + 1] = arr[i];
		
		arr[0] = data;
		size++;
	}
	// 마지막 삽입
	public void addLast(String data) {
		//마숙
	}
	// 중간에 삽입
	public void add(int idx, String data) {
		//마숙
	}
	
	//첫번째 원소 삭제
	public String remove() {
		//예외를 발생시켜서 할 수 있다.
		if(size == 0) return null;
		
		String data = arr[0];
		
		for(int i = 1; i<size ; i++) {
			arr[i-1] = arr[i];
		}
		//제일 마지막 값을 null로 해줘도 좋고 안해줘도 좋고
		size--;
		return data;
		
	}
	//중간 원소 삭제 
	public String remove(int idx) {
		//마숙 
		
		return null; //임시
	}
	
	
	
	public void printList() {
		System.out.println(Arrays.toString(Arrays.copyOf(arr, size)));
	}

}
