from sys import stdin

n = int(stdin.readline())

rope = []
for _ in range(n):
    rope.append(int(stdin.readline()))

rope.sort()
weight = 0
for i in range(n):
    weight = max(weight, rope[i] * (n - i))

print(weight)



