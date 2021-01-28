# 각 노드의 인접 노드 배열로 담은 2차원 배열
import sys
from collections import deque

def dfs(graph, v, visited):
    visited[v] = True
    print(v,end=' ')

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = False

    while queue:
        v = queue.popleft()
        print(v,end=' ')

        for i in graph[v]:
            if visited[i]:
                queue.append(i)
                visited[i] = False

n, m, start = map(int,sys.stdin.readline().split())
graph = [[] for  i in range(n+1)]
visited = [False for i in range(n+1)]

for i in range(m):
        v1, v2 = map(int, sys.stdin.readline().split())
        graph[v1].append(v2)
        graph[v2].append(v1)

for i  in range(1, n+1):
    graph[i].sort()  #인접노드 작은 것부터 방문하기로 해서 정렬

dfs(graph, start, visited)
print()
bfs(graph, start, visited)