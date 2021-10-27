package greedy.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String n = sc.nextLine();

        sc.close();

        List<Integer> number = new ArrayList<>();
        int sum = 0;
        boolean hasZero = false;

        
        for (int i = 0; i < n.length(); i++) {
            number.add(n.charAt(i) - '0');
            sum += number.get(i);
            if (number.get(i).equals(0)) {
                hasZero = true;
            }
        }
        
        if (sum % 3 != 0 || !hasZero) {
            System.out.println("-1");
            return;
        }

        Collections.sort(number, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.size(); i++ ) {
            sb.append(number.get(i));
        }

        System.out.println(sb.toString());
    }
    
}
