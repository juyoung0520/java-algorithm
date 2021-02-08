from sys import stdin

n = int(stdin.readline())

# 인덱스가 문자의 길이일때, 0 ~ 9 숫자를 추가하려할 때의 경우의 수
dp = [[0] * 10 for _ in range(101)]

#1열 초기화
for i in range(1, 10):
    dp[1][i] = 1

# 2열부터 n열까지
for i in range(2, n + 1):
    for j in range(10):
        
        # 0을 추가할 때, 그 전 수는 + 1한 경우만 가능
        if j == 0:
            dp[i][j] = dp[i - 1][j + 1]
        # 9 추가할 때, 그 전 수는 - 1한 경우만 가능
        elif j == 9:
            dp[i][j] = dp[i - 1][j - 1]
        # 1 ~ 8 추가할 때, 그 전 수는  + 1, - 1한 두 수 가능
        else:
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]

print(sum(dp[n]) % 1000000000)
