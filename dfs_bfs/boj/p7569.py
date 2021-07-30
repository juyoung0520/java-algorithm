from sys import stdin
from collections import deque

m, n, h = map(int, stdin.readline().split())
graph = []
que = deque()

def bfs():
    global graph, que, n, m, h
    days = -1
    dx = [-1, 1, 0, 0, 0, 0]
    dy = [0, 0, -1, 1, 0, 0]
    dh = [0, 0, 0, 0, -1, 1]

    while que:
        days += 1

        for _ in range(len(que)):
            a, b, c = que.popleft()

            for i in range(6):
                na = a + dx[i]
                nb = b + dy[i]
                nc = c + dh[i]

                if (0 <= na < n) and (0 <= nb < m) and (0 <= nc < h) and graph[n*nc+na][nb] == 0:
                    que.append((na, nb, nc))
                    graph[n*nc+na][nb] += 1

    for row in graph:
        if 0 in row:
            return -1
    
    return days

# 입력
for i in range(h):
    for j in range(n):
        graph.append(list(map(int, stdin.readline().split())))

# 처음에 익어있는 토마토 큐에 넣기
for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[n*i+j][k] == 1:
                que.append((j, k, i))

print(bfs())





