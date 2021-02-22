import heapq
import sys
INF = int(1e9)
input = sys.stdin.readline

# Floyd 쓰면 시간초과 (2 <= N <= 800, 0 <= E <= 200,000)
# n, e = map(int, input().split())
# graph = [[INF] * (n + 1) for _ in range(n + 1)]

# for i in range(1, n + 1):
#     for j in range(1, n + 1):
#         if i == j:
#             graph[i][j] = 0

# for _ in range(e):
#     a, b, c = map(int, input().split())
#     graph[a][b] = c
#     graph[b][a] = c

# for k in range(1, n + 1):
#     for i in range(1, n + 1):
#         for j in range(1, n + 1):
#             graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

# v1, v2 = map(int, input().split())
# route = min(graph[1][v1] + graph[v2][n], graph[1][v2] + graph[v1][n]) + graph[v1][v2]

def dijsktra(start, end):
    distance = [INF] * (n + 1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, node = heapq.heappop(q)

        if distance[node] < dist:
            continue
        
        for i in graph[node]:
            cost = dist + i[1]

            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    
    return distance[end]

n, e = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

v1, v2 = map(int, input().split())

route = min(dijsktra(1, v1) + dijsktra(v2, n), dijsktra(1, v2) + dijsktra(v1, n)) + dijsktra(v1, v2)

if route >= INF:
    print("-1")
else:
    print(route)