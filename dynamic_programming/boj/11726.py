from sys import stdin

n = int(stdin.readline())
dp = [0] * 1001 # n + 1로 할 경우, n = 1, n = 2인경우 IndexError 발생

dp[1], dp[2] = 1, 2
for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[n] % 10007)