package 수업_0817.단순연결리스트;

//데이터와 다음링크를 가지고 있는 단위
public class Node {
	//데이터 필드 (추후 제네릭을 대체하면 공용화기로 사용이 가능하다.)
	public String data;
	//링크를 저장하겠다.
	public Node link;
	
	//내가 생성자를 새롭게 정의하는 순간 기본생성자는 안만들어지니까... 
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	public Node(String data) {
		this.data = data;
		this.link = null; //이거 굳이 사용하지 않아도 알아서 null로 초기화 됨.
	}
	
	
	
}
