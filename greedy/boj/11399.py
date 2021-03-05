import sys
input = sys.stdin.readline

n = int(input())
wait = list(map(int, input().split()))
totalWait = []
current = 0

for i in sorted(wait):
    current += i
    totalWait.append(current)

print(sum(totalWait))