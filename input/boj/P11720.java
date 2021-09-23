package input.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P11720 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // // nextLine으로 하면 런타임에러, 개행 때문에 그런가?
        // String str = sc.next();
        // int sum = 0;

        // for (int i = 0; i < n; i++) {
        //     sum += str.charAt(i) - '0';
        // }

        // System.out.println(sum);
        // sc.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();	// N 은 쓸모가 없으므로 입력만 받는다.
		
		int sum = 0;
		
		for(byte value : br.readLine().getBytes()) {
			sum += (value - '0');	// 또는 (a-48)
		}
		
		System.out.print(sum);
    }
}
