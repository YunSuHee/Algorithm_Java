package 수업_0817;

import 수업_0817.순차리스트.SequentialList;

public class LinkedList_01_순차리스트 {
	public static void main(String[] args) {
		SequentialList list = new SequentialList();

		list.printList();

		list.addFirst("이해건");
		list.printList();

		list.addFirst("박수민");
		list.printList();

		list.remove();
		list.printList();

	}// main
}
