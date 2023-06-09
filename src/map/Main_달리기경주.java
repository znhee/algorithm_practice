package map;

/**
프로그래머스 1단계 : 달리기 경주
*/

import java.util.*;
class Main_달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        for(String calling : callings) {
            int rank = map.get(calling);
            
            String temp = players[rank];
            players[rank] = players[rank-1];
            players[rank-1] = temp;
            map.put(players[rank], rank);
            map.put(players[rank-1], rank-1);
        }
        
        return players;
    }
}
