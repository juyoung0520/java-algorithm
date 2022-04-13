package implement.boj;

import java.util.Scanner;

public class P1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 개행 제거 
        sc.nextLine();

        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int[] check = new int[50];

            char c = str.charAt(0);
            check[c - 'a']++;

            for (int j = 1; j < str.length(); j++) {
                int idx = str.charAt(j) - 'a';

                if (check[idx] != 0 && c != str.charAt(j)) {
                    count++;
                    break;
                }

                c = str.charAt(j);
                check[idx]++;
            }
        }

        System.out.println(n - count);

        sc.close();
    }
    
}
