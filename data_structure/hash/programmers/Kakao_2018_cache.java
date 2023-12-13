package data_structure.hash.programmers;

import java.util.LinkedList;

/*
프로그래머스 [1차] 캐시
*/

public class Kakao_2018_cache {
    public static void main(String[] args) {
        String[] cities = {"A","B","A"};
        System.out.println(solution(3, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return 5 * cities.length;
        } // 이것 때문에 안됐었다
            
        int answer = 0;
        LinkedList<String> cache = new LinkedList<String>();
        
        for (int i = 0; i < cities.length; i++) {
            String c = cities[i].toLowerCase();
    
            if (cache.remove(c)) {
                cache.add(c);
                answer += 1;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }

                cache.add(c);
                answer += 5;
            }
        }
        
        return answer;
    }     
}