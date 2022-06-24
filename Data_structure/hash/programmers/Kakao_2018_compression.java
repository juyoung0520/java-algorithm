package data_structure.hash.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Kakao_2018_compression
 * 압축
 */
public class Kakao_2018_compression {
    public static void main(String[] args) {
        System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
    }

    public static List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        char c = 'A';
        for (int i = 0; i < 26; i++) {
            map.put(c + "", i + 1);
            c += 1;
        }

        for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));

            for (int j = i + 1; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                if (!map.containsKey(sb.toString())) {
                    map.put(sb.toString(), map.size() + 1);
                    answer.add(map.get(sb.substring(0, sb.length() - 1)));
                    break;
                }
                i = j;
            }


            if (i == msg.length() - 1) {
                answer.add(map.get(sb.toString()));
                break;
            }
        }

        return answer;
    }
    
}