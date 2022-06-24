package data_structure.hash.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Kakao_2022_car_fee {
    public List<Integer> solution(int[] fees, String[] records) {
        Map<String, Integer> map = new TreeMap<>();     // 처음에 HashMap<String, List<String>>과 key list 따로 둠.
        List<Integer> prices = new ArrayList<>();
        
        for (String r : records) {
            String[] arr = r.split(" ");
            int time = arr[2].equals("IN") ? -1 : 1;
            time *= convertToTime(arr[0]);
            map.put(arr[1], map.getOrDefault(arr[1], 0) + time);
        }
        
        for (Integer time : map.values()) {
            if (time < 0) {
                time += convertToTime("23:59");
            }

            if (time > fees[0]) {
                int unit = (int)Math.ceil((time - fees[0]) / (double)fees[2]);
                prices.add(fees[1] + unit * fees[3]);
            } else {
                prices.add(fees[1]);
            }
        }
        
        return prices;
    }

    public int convertToTime(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    // public int calcTime(String start, String end) {
    //     String[] s1 = start.split(":");
    //     String[] s2 = end.split(":");
          
    //     int hour = Integer.parseInt(s2[0]) - Integer.parseInt(s1[0]);
    //     int min = Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);

    //     return hour * 60 + min;
    // }
}
