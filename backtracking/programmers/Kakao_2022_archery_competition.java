package backtracking.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kakao_2022_archery_competition
 * 양궁 대회
 */
public class Kakao_2022_archery_competition {
    int max = Integer.MIN_VALUE;
    int[] res = new int[11];
    List<int[]> answer = new ArrayList<>();
    
    public int[] solution(int n, int[] info) {
        combi(info, n, 0, 0);
        
        if (answer.isEmpty()) {
            return new int[] {-1};
        }
        
        Collections.sort(answer, (l1, l2) -> {
            for (int i = 10; i >= 0; i--) {
                if (l1[i] != l2[i])  {
                    return l2[i] - l1[i];
                }
            }
            return 0;
        });
        
        return answer.get(0);
    }
    
    public void combi(int[] info, int n, int idx, int start) {
        if (idx == n) {
            int ryan = 0, apeach = 0;
            
            for(int i = 0; i < res.length; i++) {
                if (info[i] == 0 && res[i] == 0) continue;
                
                if (info[i] < res[i]) {
                    ryan += 10 - i;
                } else {
                    apeach += 10 - i;
                }
            }
            
            if (ryan > apeach && max <= ryan - apeach) {
                if (max < ryan - apeach) {
                    answer.clear();
                }
                
                max = ryan - apeach;
                answer.add(res.clone());
            }
            return;
        }
        
        // res[i] <= info[i]일때까지 완전탐색 해도 되는데 이해안됨
        for (int i = start; i < res.length; i++) {
            res[i]++;
            combi(info, n, idx + 1, i);
            res[i]--;
        }
    }
}