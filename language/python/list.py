from sys import stdin

# 리스트 입력받기
# 5 3 1
# 0 -1 0 0 0
# -1 -1 0 1 1
# 0 0 0 1 1

m, n, h = map(int, stdin.readline().split())
graph = []
for i in range(h):
    for j in range(n):
        graph.append(list(map(int, stdin.readline().split())))