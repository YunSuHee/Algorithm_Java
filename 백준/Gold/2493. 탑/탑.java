import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Info{
    int height;
    int num;
    public Info(int height, int num){
        this.height = height;
        this.num = num;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Info> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int height = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()&&stack.peek().height<height){
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print(0+" ");
            }else{
                System.out.print(stack.peek().num+" ");
            }
            stack.push(new Info(height,i+1));
        }
    }
}