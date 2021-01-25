import sys

n = int(sys.stdin.readline())
array = []

for i in range(n):
    array.append(list(sys.stdin.readline().split()))

array.sort(key=lambda x: int(x[0]))

for i in array:
    print(i[0], i[1])
