import sys

def dfs(v):
    visited[v] = 1
    for i in range(1, n+1):
        if visited[i] == 0 and graph[v][i] == 1:
            dfs(i)

sys.setrecursionlimit(10000) # 안하면 런타임 오류 재귀 오류 남
n, m = map(int, sys.stdin.readline().split())
graph = [[0] * (n+1) for i in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1][v2] = 1
    graph[v2][v1] = 1

count = 0
for i in range(1, n+1):
    if visited[i] == 0:
        dfs(i)
        count += 1
print(count)
