package sorting.boj;
import java.util.*;
import java.io.*;

public class p10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		String[][] array = new String[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = st.nextToken();
			array[i][1] = st.nextToken();
		}
		
		Arrays.sort(array, (e1, e2) -> {
			if (Integer.parseInt(e1[0]) == Integer.parseInt(e2[0]))
				return 1;
			else 
				return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
		});
		
		for(int i = 0; i < n; i++) {
			sb.append(array[i][0]+" "+array[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}

}
