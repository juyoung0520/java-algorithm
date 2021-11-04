package string.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String str = "";

        while ((str = br.readLine()) != null) {
            int[] res = new int[4];

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                
                if (Character.isLowerCase(c)) {
                    res[0]++;
                } else if (Character.isUpperCase(c)) {
                    res[1]++;
                } else if (Character.isDigit(c)) {
                    res[2]++;
                } else {
                    res[3]++;
                }
            }


            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(' ');
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
    
}
