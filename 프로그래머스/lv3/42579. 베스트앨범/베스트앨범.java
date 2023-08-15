import java.util.*; 
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        //장르별 총 재생 수
        Map<String,Integer> genre = new HashMap<>();
        //노래별 장르, 재생 수, 인덱스
        Map<String, List<Info>> info = new HashMap<>();
        for(int i=0; i<plays.length;i++){
            if(genre.containsKey(genres[i])){ //이미 장르가 추가 되어 있는 경우
                //장르별 총 재생 수
                genre.put(genres[i],genre.get(genres[i])+plays[i]);
                //재생 수 , 인덱스
                info.get(genres[i]).add(new Info(plays[i],i));
            }else{
                //장르별 총 재생 수
                genre.put(genres[i],plays[i]);
                //재생 수 , 인덱스
                List<Info> list = new ArrayList<>();
                list.add(new Info(plays[i], i));
                info.put(genres[i],list);                
            }
            //위에 코드 세줄로 짜면
            // genre.put(genres[i],genre.getOrDefault(genres[i],0)+plays[i]);
            // info.putIfAbsent(genres[i],new ArrayList<>());
            // info.get(genres[i]).add(new Info(plays[i],i));
                      
            
        }
        //1. 장르 선정 
        List<String> genre_order = new ArrayList<>(genre.keySet());
        Collections.sort(genre_order,(o1,o2)->genre.get(o2)-genre.get(o1));
        
        //2. 노래 선정
        List<Integer> answer = new ArrayList<>();
        for(String gen : genre_order){
            List<Info> list = info.get(gen);
            //재생 수 내림차순으로 정렬
            Collections.sort(list,(o1,o2)->o2.play-o1.play);
            //베스트 앨범에 추가
            answer.add(list.get(0).idx);
            if(list.size()>1) answer.add(list.get(1).idx);
            
            
        }
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }

        return result;
    }
}
class Info{
    int play;
    int idx;
    public Info(int play, int idx){
        this.play = play;
        this.idx = idx;
            
    }
}