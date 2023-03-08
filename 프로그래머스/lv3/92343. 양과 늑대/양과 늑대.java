import java.util.ArrayList;


class Solution {
    static int[] info;
    static ArrayList<Integer>[] graph;
    static int max = 0;
    
    public int solution(int[] Info, int[][] edges) {
        info = Info;
        
        //해당 index는 부모 노드이고 ArrayList 배열에 자식 Node를 넣는다.
        graph = new ArrayList[info.length];

        for(int[] edge : edges){
            int parent = edge[0]; //부모노드 번호
            int child = edge[1]; //자식노드 번호

            if(graph[parent] == null){ //자식이 하나도 없으면 새로운 arrayList 생성해줌
                graph[parent] = new ArrayList<>();

            }
            //graph에 자식 정보 넣기
            graph[parent].add(child);
        }

        //다음에 방문할 리스트
        ArrayList<Integer>nodelist=new ArrayList<>();

        //시작 노드
        nodelist.add(0);

        //현재 노드, 양의 수, 늑대 수 , 다음으로 방문할 수 있는 노드들
        dfs(0,0,0,nodelist);

        return max;

    }

    private static void dfs(int nowNode, int sheep, int wolf, ArrayList<Integer> nodelist) {

        //현재 노드에 있는 동물 확인 후 동물 수 증가 (0 -> 양 , 1->늑대)
        if(info[nowNode] == 0) sheep+=1;
        else wolf += 1;

        if(sheep <= wolf) return;
        //최대값 갱신
        max = Math.max(max, sheep);

        //다음 노드 리스트 새로 생성
        ArrayList<Integer> newList = new ArrayList<>();
        newList.addAll(nodelist); //기존꺼 전부 복사
        newList.remove(Integer.valueOf(nowNode)); //현재 위치 제거 (객체 제거)
        //현재 노드의 자식 노드 추가
        if(graph[nowNode] != null) newList.addAll(graph[nowNode]);

        //갈 수 있는 모든 노드
        for(int node : newList){
            dfs(node, sheep,wolf,newList);
        }


    }
}
