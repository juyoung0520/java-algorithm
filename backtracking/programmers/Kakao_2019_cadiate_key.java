package backtracking.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Kakao_2019_cadiate_key
 * 후보키
 */
public class Kakao_2019_cadiate_key {
    public List<String> candidate = new ArrayList<>();

    public int solution(String[][] relation) {
        // 후보키 조합 찾기
        for (int i = 0; i < relation[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            dfs(relation, 0, i + 1, 0, list);
        }

        return candidate.size();
    }

    public void dfs(String[][] relation, int idx, int max, int start, List<Integer> list) {
        if (idx == max) {
            // 유일성 검사
            Set<String> set = new HashSet<>();

            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : list) {
                    s += relation[i][j];
                }

                if (set.contains(s)) {
                    return;
                }
                
                set.add(s);
            }
            
            // 최소성 검사
            String key = "";
            for (Integer i : list) {
                key += i;
            }
            
            for (String c : candidate) {
                int count = 0;
                for (int i = 0; i < key.length(); i++) {
                    String sub = key.substring(i, i+1);
                    if (c.contains(sub)) {
                        count++;
                    }
                }

                if (count == c.length()) {
                    return;
                }
            }
            candidate.add(key);
            
            return;
        } 

        for (int i = start; i < relation[0].length; i++) {
            list.add(i);
            dfs(relation, idx + 1, max, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}