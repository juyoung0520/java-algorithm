package string.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        sc.close();

        int[] arr = new int[26];

        Arrays.fill(arr, -1);

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';

            if (arr[index] == -1) {
                arr[str.charAt(i) - 'a'] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb.toString());
    }
    
}
