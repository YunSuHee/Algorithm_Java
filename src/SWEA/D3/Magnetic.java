package SWEA.D3;

import java.util.Scanner;

public class Magnetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<11;tc++) {
			int n =100;
			int[][] table = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					table[i][j]= sc.nextInt();
				}
			}
			int answer =0;
			for(int i=0; i<n;i++) {
				int check =0;
				for(int j=0; j<n;j++) {
					if(table[j][i]==0) {
						continue;
					}else if(table[j][i] == 1) {
						check =1;
					}else if(table[j][i]==2 && check == 1) {
						check =2;
						answer+=1;
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
			
		}

	}

}

/*
			//1은 n극 아래로/ 2는 s극 위로
			int sum=0;

			for(int i=0; i<n;i++) {
				String check ="";
				for(int j=0; j<n;j++) {
					//0 이거나 처음이 2 추가 안함
					if(table[j][i] ==0|| (table[j][i]==2 && check.isEmpty()) ){
						continue;
					}else {
						check+=table[j][i]+"";
					}
				}
				//check에서 마지막이 1인거 뺴
				String temp="";
				for(int l=check.length()-1;l>=0;l--) {
					if(check.charAt(l)==1 && check.isEmpty()) {
						continue;
					}else {
						temp+=check.charAt(l);
					}
					
				}
				//temp 문자 뒤집기
				StringBuffer sb = new StringBuffer(temp);
				check = sb.reverse().toString();
				System.out.println(check);
				//교착 숫자 세기
				int answer=1;
				for(int k=0;k<check.length()-1;k++) {
					//순수 12 개수 찾기
					if(check.charAt(k)==check.charAt(k+1)) {
						continue;
					}else {
						answer+=1;
					}
					
				}
				//교착은 쌍이니까 /2
				sum+=answer/2;
				System.out.println(sum);
			}
			System.out.println("#"+tc+" "+sum);
 */