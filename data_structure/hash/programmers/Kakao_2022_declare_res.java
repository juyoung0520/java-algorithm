package data_structure.hash.programmers;

/**
 * Kakao_2022_declare_res
 */
import java.util.*;

public class Kakao_2022_declare_res {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idIdx = new HashMap<>();
        List<HashSet<String>> arr = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            idIdx.put(id_list[i], i);
            arr.add(new HashSet<>());
        }
        
        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String user1 = st.nextToken();
            String user2 = st.nextToken();
            
            arr.get(idIdx.get(user2)).add(user1);
            // for (int j = 0; j < id_list.length; j++) {
            //     if (id_list[j].equals(user2)) {
            //         arr.get(j).add(user1);
            //     }
            // }
        }
        
        
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).size() >= k) {
                for (String s : arr.get(i)) {
                    answer[idIdx.get(s)]++;
                }
                // for (int j = 0; j < id_list.length; j++) {
                //     if (arr.get(i).contains(id_list[j])) {
                //         answer[j]++;
                //     }
                // }
            }
        }
        
        return answer;
    }
}