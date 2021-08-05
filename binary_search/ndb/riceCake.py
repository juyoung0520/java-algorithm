from sys import stdin

n, m = map(int, stdin.readline().split())
arr = list(map(int, stdin.readline().split()))

start = 0
end = max(arr)

result = 0
while start <= end:
    mid = (start + end) // 2
    sum = 0

    for i in arr:
        if i > mid:
            sum += (i - mid)
    
    if sum < m:
        end = mid - 1
    # 최대한 덜 자른것 구하는 것이므로
    else: 
        result = mid
        start = mid + 1

print(result)

