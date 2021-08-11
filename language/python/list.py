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

# 2차원 리스트 만들기
# [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
arr1 = [[0 for _ in range(3)]] * (3)
arr2 = [[0 for _ in range(3)] for _ in range(3)]
print(arr2)