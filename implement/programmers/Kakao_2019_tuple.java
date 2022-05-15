package implement.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kakao_2019_tuple {
    public static void main(String[] args) {
        String s = "{{2}, {2, 3}}";
        Pattern p = Pattern.compile("[0-9]+");
        Matcher matcher = p.matcher(s);
        while (matcher.find()) {
            String tmp = matcher.group();
            System.out.println(tmp);
        }
    }
    public List<Integer> solution(String s) {
        s = s.substring(2, s.length()-2);
        s = s.replace("},{", "-");
        String[] arr = s.split("-");

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                }
                return 0;
            }
        });

        List<Integer> res = new ArrayList<>();
        for (String str : arr) {
            String[] tmp = str.split(",");

            for (int i = 0; i < tmp.length; i++) {
                int value = Integer.parseInt(tmp[i]);

                if (!res.contains(value)) {
                    res.add(value);
                }
            }
        }

        return res;
    }
}
