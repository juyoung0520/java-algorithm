package input.boj;

import java.util.Scanner;

public class P1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week =  {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};


        int x = sc.nextInt();
        int y = sc.nextInt();

        int total = 0;

        for (int i = 0; i < x-1; i++) {
            total += days[i];
        }
        
        total += y;

        System.out.println(week[total % 7]);
        sc.close();
    }
    
}
