#bfs로만 풀어야 하는 문제 (한 방향으로 쭉 익는 것이 아니라 익은 토마토 주변부터 익기 시작해서) 토하고 마시고 토하고..
from sys import stdin
from collections import deque

def bfs(m, n, array, ripe):
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    days = -1 #처음 부터 다 익었으면 0 출력해야하므로

    while ripe:
        days += 1 

        for _ in range(len(ripe)):
            x, y = ripe.popleft()

            for j in range(4):
                a = x + dx[j]
                b = y + dy[j]

                if (0 <= a < n) and (0 <= b < m) and (array[a][b] == 0):
                    array[a][b] += 1
                    ripe.append([a, b])
    
    for row in array:
        if 0 in row:
            return -1

    return days

m, n = map(int, stdin.readline().split())
array, ripe = [], deque()

for i in range(n):
    array.append(list(map(int, stdin.readline().split())))

# 이미 익은 토마토들을 queue에 넣어놔야 함
for i in range(n):
    for j in range(m):
        if array[i][j] == 1:
            ripe.append([i,j])

print(bfs(m, n, array, ripe))