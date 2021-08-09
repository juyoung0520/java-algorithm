from sys import stdin

n, m = map(int, stdin.readline().split())

coin = []
for _ in range(n):
    coin.append(int(stdin.readline().split()))

dp = [10001] * (m + 1)
dp[0] = 0

for i in coin:
    for j in range(i, m + 1):
        if dp[j - i] != 10001:
            dp[j] = min(dp[j], dp[j - i] + 1) 

if dp[m] == 10001:
    print(-1)
else:
    print(dp[m]) 

