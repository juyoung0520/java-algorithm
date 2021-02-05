from sys import stdin

n = int(stdin.readline())
foods = list(map(int, stdin.readline().split()))
d = [0] * 100

#다이나믹 프로그래밍 (보텀업)
d[0] = array[0]
d[1] = max(array[0], array[1])
for i in range(2, n):
    d[i] = max(d[i - 1], d[i - 2] + foods[i])

print(d[n - 1])
        


