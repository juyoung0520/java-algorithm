import sys
from collections import deque

def bfs(v):
    queue = deque([v])
    visited[v] = 1

    while queue:
        v = queue.popleft()

        for i in graph[v]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = 1
                parent[i] = v

n = int(sys.stdin.readline())
graph = [[] for i in range(n+1)]
visited = [0 for i in range(n+1)]
parent = [0 for i in range(n+1)]

for i in range(n-1):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

bfs(1)
for i in range(2, n+1):
    print(parent[i])