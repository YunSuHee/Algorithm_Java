package 수업_0817;
import java.util.Arrays;

public class LinkedList_07_삽입정렬 {
	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 16, 8, 31, 22 };

		// 정렬 하겠다.
		for (int i = 1; i < data.length; i++) {
			int key = data[i]; // 이번에 정렬할 값.
			int j; // 정렬할 위치

			for (j = i - 1; j >= 0 && key < data[j]; j--) //앞에 데이터가 키보다 크면 현재 위치에 들어와 
				data[j + 1] = data[j];

			// 다 이동했으면 key를 삽입한다.
			data[j + 1] = key; // j+1 이 되어야 하는지는 생각을 해볼것!!!!

			System.out.println(Arrays.toString(data));

		} // 몇 사이클을 돌건지...

	}
}
