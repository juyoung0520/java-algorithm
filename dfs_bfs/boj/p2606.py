# 인접 노드 그래프 DFS
from sys import stdin
from collections import deque

computer = int(stdin.readline())
connect = int(stdin.readline())
graph = [[] for _ in range(computer + 1)]
visited = [0] * (computer + 1)
count = 0

def dfs(com):
    global count, visited 
    visited[com] = 1

    for i in graph[com]:
        if visited[i] == 0:
            dfs(i)
            count +=1

def bfs(com):
    global count, visited
    que = deque([com])
    visited[com] = 1

    while que:
        tmp = que.popleft()

        for i in graph[tmp]:
            if visited[i] == 0:
                que.append(i)
                visited[i] = 1
                count += 1

for i in range(connect):
    a, b = map(int, stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

# dfs(1)
bfs(1)
# 1번 통해 감염된 컴퓨터 수니까 1번 제외
print(count)

