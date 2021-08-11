# 안됨 개빡침 런타임 에러

from sys import stdin

#  개행 제거
first = stdin.readline().strip()
second = stdin.readline().strip()

firstLen = len(first)
secondLen = len(second)

dp = [[0] * (firstLen + 1) for _ in range(secondLen + 1)]

for i in range(1, firstLen + 1):
    for j in range(1, secondLen + 1):
        if first[i - 1] == second[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

print(dp[-1][-1])