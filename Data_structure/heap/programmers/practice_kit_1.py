import heapq
def solution(scoville, K):
    count = 0
    h = []

    for i in scoville:
        heapq.heappush(h, i)

    while h[0] < K:
        if len(h) < 2:
            return -1

        heapq.heappush(h, heapq.heappop(h) + (heapq.heappop(h) * 2))
        count += 1
    
    return count