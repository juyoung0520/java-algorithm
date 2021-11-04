package string.boj;
import java.util.Arrays;
import java.util.Scanner;

/**
 * P11656
 */
public class P11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        sc.close();

        String[] arr = new String[str.length()];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.substring(i, str.length());
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}