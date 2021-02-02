#거리를 구하는 거니까 거리를 mid로..
from sys import stdin

n, c = map(int, stdin.readline().split())
home = [int(stdin.readline()) for _ in range(n)]
home.sort()

start = 1 #거리가 가장 작은 경우 
end = home[- 1] - home[0] #거리가 가장 먼 경우, 리스트[-1]은 마지막 요소, 리스트[-2]는 마지막에서 두번째 요소
result = 0
''
while start <= end:
    mid = (start + end) // 2 #가장 인접한 경우의 거리
    current = home[0] #가장 최근에 설치된 공유기. 처음 설치는 첫 원소로
    count = 1 #설치된 공유기 수 
    
    for i in range(len(home)):
        if home[i] - current >= mid:
            count += 1
            current = home[i]
    
    if count >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1
    
print(result)