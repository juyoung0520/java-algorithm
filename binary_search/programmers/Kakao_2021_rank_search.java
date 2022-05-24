package binary_search.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kakao_2021_rank_search {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            String[] arr = info[i].split(" ");
            putMap(0, arr, "");
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");

            if (map.containsKey(q[0])) {
                answer[i] = binarySeach(q[0], Integer.parseInt(q[1]));
            }
        }
        
        return answer;
    }

    public void putMap(int idx, String[] arr, String str) {
        if (idx == arr.length - 1) {
            int score = Integer.parseInt(arr[idx]);

            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<Integer>());
            } 
            map.get(str).add(score);
            
            return;
        }

        putMap(idx + 1, arr, str + "-");
        putMap(idx + 1, arr, str + arr[idx]);
    }

    public int binarySeach(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }
}
