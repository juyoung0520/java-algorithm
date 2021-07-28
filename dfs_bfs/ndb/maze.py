from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().split())
graph = []
for i in range(n):
    graph.append(list(map(int, stdin.readline().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx <= -1 or nx >= n or ny <= -1 or ny >= m:
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.appen((nx, ny))
    # 마지막 탈출구 값은 최단 거리
    return graph[n-1][m-1]

print(bfs(0, 0))
