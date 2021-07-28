# 입력받기
from sys import stdin

n, m, k = map(int, stdin.readline().split())
team = 0

for i in range(k+1):
    girls, boys = n-(k-i), m-i
    if girls*boys < 0:
        continue
    team = max(team, min(girls//2, boys//1))

print(team)

                                                                                                                                                                                                                  