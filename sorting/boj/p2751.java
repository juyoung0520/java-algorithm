package sorting.boj;
import java.util.*;
import java.io.*;

public class p2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			array.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(array);
		
		for(int i : array) {
			sb.append(i).append('\n');
		}
		System.out.println(sb);
	}

}
