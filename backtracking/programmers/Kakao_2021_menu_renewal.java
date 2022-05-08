package backtracking.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Kakao_2021_menu_renewal {
    Map<String, Integer> map;
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for (int n : course) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            
            for (String order : orders) {
                StringBuilder sb = new StringBuilder();
                if (order.length() >= n) {
                    // 조합
                    dfs(sb, order, 0, 0, n);
                }
            }
            
            for (Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
            
            for (Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
             
            Collections.sort(answer);
        }
        
        return answer;
    }
    
    public void dfs(StringBuilder sb, String order, int startIdx, int cnt, int n) {
        if (cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            return;
        }
        
        for (int i = startIdx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            dfs(sb, order, i+1, cnt+1, n);
            sb.delete(cnt, cnt+1);
        }
    }
}
