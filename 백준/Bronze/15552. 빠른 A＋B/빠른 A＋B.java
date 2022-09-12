import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int n = Integer.parseInt(br.readLine());
		for (int t = 1; t <= n; t++) {
			st = new StringTokenizer(br.readLine());
			bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");

		}
		
		//둘중 하나만 적어도 됨!
		bw.flush(); //남아있는 데이터를 모두 출력시킴
		bw.close(); //스트림을 닫음
		
	}
}