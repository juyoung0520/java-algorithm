from sys import stdin

n = int(stdin.readline())
foods = list(map(int, stdin.readline().split()))
# 인덱스 창고까지의 최대값
d = [0] * 100

# 다이나믹 프로그래밍 (보텀업)
d[0] = foods[0]
d[1] = max(foods[0], foods[1])
for i in range(2, n):
    # i번째 창고를 선택하지 않을 경우와 선택할 경우 중 최대값
    d[i] = max(d[i - 1], d[i - 2] + foods[i])

print(d[n - 1])