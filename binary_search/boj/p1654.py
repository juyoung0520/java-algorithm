from sys import stdin

k, n = map(int, stdin.readline().split())
lan = [int(stdin.readline()) for _ in range(k)]
start, end = 1, max(lan)
result = 0

while start <= end:
    sum = 0
    mid = (start + end) // 2

    for i in lan:
        if i >= mid:
            sum += (i // mid)
    
    if sum < n:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)