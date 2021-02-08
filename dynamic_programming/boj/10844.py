from sys import stdin

n = int(stdin.readline())
dp = [0] * 101
dp[1] = 9
dp[2] = dp[1] * 2 - 1
dp 