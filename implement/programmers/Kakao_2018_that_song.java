package implement.programmers;

import java.util.ArrayList;
import java.util.List;

/*
* 방금 그곡
*/
public class Kakao_2018_that_song {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        m = convert(m);

        for (String s : musicinfos) {
            String[] arr = s.split(",");
            String[] start = arr[0].split(":");
            String[] end = arr[1].split(":");

            int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
            int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            int time = hour * 60 + minute;

            String music = convert(arr[3]);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < time; j++) {
                sb.append(music.charAt(j % music.length()));
            }

            if (sb.toString().contains(m) && time > max) {
                max = time;
                answer = arr[2];
            }
        }

        return answer;
    }

    public static String convert(String m) {
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        return m;
    }
}
