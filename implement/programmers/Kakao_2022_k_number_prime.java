package implement.programmers;

/*
* k 진수 소수 개수 구하기
*
*/

public class Kakao_2022_k_number_prime {
    public int solution(int n, int k) {
        int answer = 0;
        // 진수 바꾸기
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String str = sb.reverse().toString();
        
        // 소수 구하기
        String arr[] = str.split("0+");
        for (int i = 0; i < arr.length; i++) {
            long num = Long.parseLong(arr[i]);  // n이 최대 1,000,000 !!
            
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        
        if (num == 2) {
            return true;
        }
        
        // O(N√N) 시간복잡도
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
