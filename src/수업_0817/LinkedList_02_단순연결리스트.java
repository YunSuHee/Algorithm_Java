package 수업_0817;

import 수업_0817.단순연결리스트.SinglyLinkedList;

public class LinkedList_02_단순연결리스트 {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		
		list.printList();
		
		list.addFirst("이해건");
		list.printList();
		
		list.addFirst("김동현");
		list.printList();
		
		list.addLast("염선재");
		list.printList();
		
		list.add(1, "김인중");
		list.printList();
		
		list.remove();
		list.printList();
		
		list.remove(1);
		list.printList();
		
		list.add(1, "공조한");
		list.printList();
		
	}//main
}
