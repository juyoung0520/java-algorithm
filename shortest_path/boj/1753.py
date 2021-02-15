import heapq
import sys
INF = int(1e9)
input = sys.stdin.readline

def dijsktra(start):
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

v, e = map(int, input().split())
start = int(input())
graph = [[] for _ in range(v + 1)]
distance = [INF] * (v + 1)

for _ in range(e):
    x, y, w = map(int, input().split())
    graph[x].append((y, w))

dijsktra(start)

for i in range(1, v + 1):
    if distance[i] >= INF:
        print("INF")
    else:
        print(distance[i])

