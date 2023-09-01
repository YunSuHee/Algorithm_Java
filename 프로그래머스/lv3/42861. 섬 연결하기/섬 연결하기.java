import java.util.*;
class Solution {
    static int[] parent;
    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]); //parent[a]에 할당을 안해줘도 되는데 그러면 재귀를 더 많이 돌게 됨
    }
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
    public int solution(int n, int[][] costs) {
        //크루스칼로 푼다
        //1.그래프의 간선들을 비용 기준으로 오름차순 정렬한다.
        //2-1.정렬된 간선 리스트를 순서대로 선택해, 간선의 정점들을 연결한다.
        //2-2.정점을 연결하는것은 union-find의 union으로 구현
        //3.만약 간선의 두 정점 a,b가 이미 연결(같은 부모를 갖는지)되어 있으면 스킵. (사이클이 형성되면 안되니까)
        //4. 위 과정 반복해 최소 비용의 간선들만 이용해 모든 정점 연결
        
        //초기화
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        //비용기준으로 정렬
        Arrays.sort(costs,new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                return o1[2]-o2[2];
            }
        });
        //Arrays.sort(costs,(o1,o2)->o1[2]-o2[1]);
        
        int result = 0;
        for(int i=0; i<costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            if(find(a) != find(b)){
                union(a,b);
                result += cost;
            }
            
        }
        return result;
    }
}
