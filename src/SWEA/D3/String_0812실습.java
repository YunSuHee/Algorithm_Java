package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class String_0812실습 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 for(int i=0;i<10;i++) {
			 int n=sc.nextInt();
			 String target =sc.next();
			 String text = sc.next();
			 
			 int cnt =0;
			 String[] targetArr = target.split("");//찾는 문자
			 String[] textArr = text.split("");//원본 문자

			 
			 int index =0;
//|| textArr[j].equals(targetArr[0])
			 for(int j=0; j<textArr.length; j++) {
				 if(textArr[j].equals(targetArr[index %=targetArr.length]) ) {
					 if(index == targetArr.length-1) cnt++;
					 index++;
				 } else if (index>0){ //tti

				     index=0;
				     j--; //지금 포문 다시 돌기 
				 }
			 }
			 //tti ttt 일떄 검사해보기
			 System.out.println("#"+n +" "+cnt);
			 


		 }

	}

}
