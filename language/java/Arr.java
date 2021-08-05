package language.java;
import java.util.Arrays;

public class Arr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        // 문자열로 출력
        System.out.println(Arrays.toString(arr));
        System.out.println();

        // 정렬
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // binary search
        System.out.println(Arrays.binarySearch(arr, 3));

        // equlas
        int[] a1 = { 1, 2, 3, 4, 5 };
        int[] a2 = { 0, 1, 1, 1, 1, 1 };
        System.out.println(Arrays.equals(arr, a1));
        System.out.println(Arrays.equals(arr, a2));
        System.out.println();
         
        // 배열을 초기화
        Arrays.fill(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
    
}
