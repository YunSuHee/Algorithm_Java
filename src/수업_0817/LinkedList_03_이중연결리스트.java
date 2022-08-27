package 수업_0817;

import 수업_0817.이중연결리스트.DoublyLinkedList;

public class LinkedList_03_이중연결리스트 {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		list.addFirst("임혜진");
		list.printList();

		list.addLast("박수민");
		list.printList();

		list.add(1, "이윤주");
		list.printList();

		list.remove();
		list.printList();

		list.remove(1);
		list.printList();
	}// main
}
