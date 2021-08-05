from sys import stdin

n, m = map(int, stdin.readline().split())
lesson = list(map(int, stdin.readline().split()))

start = max(lesson)
end = sum(lesson)

# mid는 블루레이 크기
res = 0
while start <= end:
    mid = (start + end) // 2
    total, count = 0, 1
    
    for i in lesson:
        if (total + i) > mid:
            total = 0
            count += 1
        total += i
    
    if count > m:
        start = mid + 1
    else:
        res = mid
        end = mid - 1
    
print(res)
    



