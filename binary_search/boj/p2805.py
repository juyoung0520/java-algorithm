#pypy로 제출하니까 성공
from sys import stdin

n, m = map(int, stdin.readline().split())
tree = list(map(int, stdin.readline().split()))

start = 0
end = max(tree)
result = 0

while start <= end:
    sum = 0
    mid = (start + end) // 2

    for i in tree:
        if i > mid:
            sum += i - mid
    
    if sum < m:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)