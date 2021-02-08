import sys

a, b = sys.stdin.readline().split()

# total = 0
# pypy는 시간초과 안남
# for i in list(map(int, a)):
#     for j in list(map(int, b)):
#         total += i * j

print(sum(list(map(int, a))) * sum(list(map(int, b))))