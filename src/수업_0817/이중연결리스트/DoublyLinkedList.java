package 수업_0817.이중연결리스트;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size;

	// 해도그만 안해도 그만
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// 조회
	public Node get(int idx) {
		if (idx < 0 || idx >= size)
			return null;
		Node curr;
		// 뒤에서부터 찾겠다.
		if (idx > size / 2) {
			curr = tail;
			for (int i = size - 1; i > idx; i--)
				curr = curr.prev;
		}
		// 앞에서 부터 찾겠다.
		else {
			curr = head;
			for (int i = 0; i < idx; i++)
				curr = curr.next;
		}
		return curr;

	}

	// 첫번쨰 노드 삽입
	public void addFirst(String data) {
		Node node = new Node(data);

		node.next = head;
		if (head != null)
			head.prev = node;

		head = node;
		size++;

		// 노드가 새로운 노드 하나뿐이라면, 시작이자 마지막노드
		if (head.next == null)
			tail = head;
	}

	// 마지막 노드 삽입
	public void addLast(String data) {
		Node node = new Node(data);

		if (size == 0) {
			addFirst(data);
			return;
		}

		tail.next = node;
		node.prev = tail;
		tail = node;
		size++;

	}

	// 중간 노드 삽입
	public void add(int idx, String data) {
		if (idx < 0 || idx > size)
			return; // 예외처리

		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == size) {
			addLast(data);
			return;
		}
		Node prevNode = get(idx - 1);
		Node nextNode = prevNode.next;
		Node node = new Node(data);

		// 이전노드와 새로만든 노드 연결
		prevNode.next = node;
		node.prev = prevNode;

		// 이후노드와 새로만든 노드 연결
		node.next = nextNode;
		nextNode.prev = node;
		size++;
	}

	// 첫번째 노드 삭제
	public String remove() {
		if (head == null) // 다른말로 size == 0 일때
			return null;

		String data = head.data;

		Node nextNode = head.next;

		if (nextNode != null)
			nextNode.prev = null;
		// 헤드의 위치를 바꾼다.
		head = nextNode;
		size--;

		if (size == 0)
			tail = null;
		return data;
	}

	// 중간 노드 삭제
	public String remove(int idx) {
		if (idx >= size || idx < 0)
			return null;
		if (idx == 0)
			return remove();

		Node prevNode = get(idx - 1);
		Node nextNode = prevNode.next.next;

		String data = prevNode.next.data;

		if (nextNode != null) {
			nextNode.prev = prevNode;
			prevNode.next = nextNode;
		} else {
			prevNode.next = null;
			tail = prevNode;
		}
		size--;
		return data;
	}

	// 출력
	public void printList() {
		Node curr = head;
		if (head == null) {
			System.out.println("지금은 공백리스트 미안~!");
			return;
		}

		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}

		System.out.println();
	}

}
