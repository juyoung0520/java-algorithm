package data_structure.hash.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kakao_2019_open_chatting {
    public String[] solution(String[] record) {
        List<Boolean> arr = new ArrayList<>();
        List<String> uids = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for (String r : record) {
            String[] s = r.split(" ");
            
            if (s[0].equals("Change")) {
                map.put(s[1], s[2]);
            } else if (s[0].equals("Enter")) {
                arr.add(true);
                map.put(s[1], s[2]);
                uids.add(s[1]);
            } else {
                arr.add(false);
                uids.add(s[1]);
            }
        }
        
        String[] answer = new String[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            if (arr.get(i)) {
                answer[i] = map.get(uids.get(i)) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(uids.get(i)) + "님이 나갔습니다.";
            }
        }
    
        return answer;
    }
}
