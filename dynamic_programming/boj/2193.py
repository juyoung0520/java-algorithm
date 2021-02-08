from sys import stdin

n = int(stdin.readline())
dp = [0] * 91
dp[1], dp[2] = 1, 1

for i in range(3, n+1):
    # 1을 추가하려면 앞이 무조건 0이어야 함 -> d[i - 2]가지 경우에다 '01' 붙이기
    # 0을 추가하는 건 앞이 무슨 수든 상관 없음 -> d[i - 1]가지 경우에다 '0' 붙이기
    dp[i] = dp[i - 1] + dp[i - 2]

print(dp[n])