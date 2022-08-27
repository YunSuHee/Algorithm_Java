package 수업_0817.단순연결리스트;

public class SinglyLinkedList {
	private Node head; // 노드의 시작점
	private int size; // 있으면 굉장히 편리하기 때문에..

	public SinglyLinkedList() {
		// 아래의 코드는 필요한것인가??? (X) 필요없다.
		this.head = null;
		this.size = 0;
	}

	// 조회
	public Node get(int idx) {
		// 예외를 발생시킬 수도 있고 기타 등등의 작업을 할 수 도 있을 것 같다.
		if (idx < 0 || idx >= size) {
			return null;
		}
		Node curr = head;

		// 해당 위치까지 curr을 옮긴다.
		for (int i = 0; i < idx; i++)
			curr = curr.link;

		return curr;

	}

	// 첫번째 원소 삽입
	public void addFirst(String data) {
		// 노드를 생성한다. 생성자를 만들어 놓았기 때문에 아래와 같이 작성가능.
		Node node = new Node(data);
		node.link = head; // 새로만든 노드의 링크를 head로 변경
		head = node; // head가 새로만든 노드를 가리키게 수정한다.
		size++;
	}

	// 마지막 원소 삽입
	public void addLast(String data) {
		Node node = new Node(data);

		// size == 0 이라는 것은 첫번쨰 노드에 넣는것과 동일하니까 이렇게 해도 괜찮겠다.
		if (size == 0) {
			addFirst(data);
			return;
		}

		// 마지막 노드를 찾아가기
		Node curr = head;
		while (curr.link != null)
			curr = curr.link;

		curr.link = node;
		size++;
	}

	// 중간 원소 삽입
	public void add(int idx, String data) {
		if (idx < 0 || idx > size)
			return; // 인덱스를 잘못 넣었을 때
		// 범위를 아주 관대하게 설정할 수 도 있다. 이것이 내가 작성하는 맛?
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == size) {
			addLast(data);
			return;
		}

		Node pre = get(idx - 1);

		Node node = new Node(data);

		// 순서가 굉장히 중요하다.
		node.link = pre.link;
		pre.link = node; // 얘 먼저하는 순간 뒤에 날아감.

		size++;
	}

	// 첫번째 원소 삭제
	public String remove() {
		if (head == null)
			return null; // 혹은 예외발생

		String data = head.data;
		head = head.link; // 헤드의 위치를 조정한다.
		size--;

		return data;
	}

	// 중간 원소 삭제
	public String remove(int idx) {
		if (idx == 0)
			return remove();

		// 범위를 벗어났다면?
		if (idx < 0 || idx >= size)
			return null; // 예외처리 가넝

		Node pre = get(idx - 1);

//		Node rmNode = get(idx); //1번
		Node rmNode = pre.link; // 2번 //데이터가 많을 때는 이게 더 빠르다.

		String data = rmNode.data;
//		String data = pre.link.data; //위코드랑 똑같은데 가독성이 쬐애끔 떨어질지도?

		pre.link = rmNode.link; // 연결끊고 다음노드로 바로 연결
//		pre.link = pre.link.link;
		size--;

		return data;
	}

	public void printList() {
		Node curr = head;
		if (head == null) {
			System.out.println("지금은 공백리스트 미안~!");
			return;
		}

		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}

		System.out.println();
	}
}
