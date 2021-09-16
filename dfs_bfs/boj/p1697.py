from sys import stdin
from collections import deque

n, k = map(int, stdin.readline().split())

MAX = 100000
time = [0] * (MAX+1)

que = deque([n])

while que:
    current = que.popleft()

    if current == k:
        print(time[current])
        break

    for i in (current-1, current+1, current*2):
        if 0 <= i <= MAX and not time[i]:
            time[i] = time[current] + 1
            que.append(i)




