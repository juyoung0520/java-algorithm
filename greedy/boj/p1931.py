# 실버 2
from sys import stdin

n = int(stdin.readline())

meeting = []
for _ in range(n):
    meeting.append(list(map(int, stdin.readline().split())))

meeting.sort(key=lambda x: (x[1], x[0]))
end, count = 0, 0

for a, b in meeting:
    if a >= end:
        count += 1
        end = b

print(count)






