package map;

/**
 프로그래머스 1단계 : 추억 점수
*/

import java.util.*;

class Main_추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++) {
            int count = 0;
            for(int j=0; j<photo[i].length; j++) {
                if(map.containsKey(photo[i][j])) {
                    count += map.get(photo[i][j]);
                } 
                answer[i] = count;
            }
        }
        
        return answer;
    }
}
