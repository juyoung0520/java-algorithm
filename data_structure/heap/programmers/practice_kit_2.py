import heapq
def solution(jobs):
    divide = len(jobs)
    first = heapq.heappop(jobs)
    time = first[0] + first[1]
    total = first[1]

    jobs.sort(key = lambda x: x[1])

    while jobs:
        do = jobs.popleft()
        time += do[1]
        total += time - do[0]
    
    return total / divide
