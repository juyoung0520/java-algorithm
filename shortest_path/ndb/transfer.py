import heapq
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한 - 10억

def dijsktra(start):
    q = []
    # 시작노드 큐에 삽입, 거리 0 으로 설정
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, node = heapq.heappop(q)
        # 이미 방문한 경우 넘기기
        if distance[node] < dist:
            continue
        for i in graph[node]:
            cost = dist + i[1]
            #현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

n, m, start = map(int, input().split())
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력받기
for _ in range(m):
    x, y, z = map(int, input().split())
    # x번 노드에서 y번 노드로 가는 비용이 z
    graph[x].append((y, z))

dijsktra(start)

count = 0
max_distance = 0
for d in distance:
    if d != INF:
        count += 1
        max_distance = max(max_distance, d)

# 시작노드 제외
print(count - 1, max_distance)
