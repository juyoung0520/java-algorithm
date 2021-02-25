import sys
input = sys.stdin.readline

start, mid, end = map(int, input().split())
print(max((mid - start - 1), (end - mid - 1)))

