package implement.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * Kakao_20218_news_clustering
 */
public class Kakao_20218_news_clustering {
    public static void main(String[] args) {
        solution("FRANCE", "french");
    }
    public static int solution(String str1, String str2) {
        int union = 0, intersection = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length()-1; i++) {
            String subStr = str1.substring(i, i+2);
            if (validCheck(subStr)) {
                map1.put(subStr, map1.getOrDefault(subStr, 0) + 1);
                union++;
            }
        }

        for (int i = 0; i < str2.length()-1; i++) {
            String subStr = str2.substring(i, i+2);
            if (validCheck(subStr)) {
                map2.put(subStr, map2.getOrDefault(subStr, 0) + 1);
                union++;
            }
        }

        for(String key : map1.keySet()){
            if(map2.get(key) != null) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }
        union -= intersection;

        if (union == 0) {
            return 65536;
        }
        
        double f = ((double)intersection / (double)union) * 65536;
        return (int) Math.floor(f);
    }

    public static boolean validCheck(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}