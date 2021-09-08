// 실버 4
package greedy.boj;
import java.util.*;

public class P2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int weight = 0;
        Collections.sort(arr);
        for (int i = 0; i < n; i++) {
            weight = Math.max(weight, arr.get(i) * (n - i));
        }

        System.out.println(weight);

        sc.close();
    }

}