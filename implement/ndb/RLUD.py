n = int(input())
x, y = 1, 1
move = input().split() # 문자열이라서

d = ['D', 'U', 'L', 'R']
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for m in move:
    idx = d.index(m)
    a, b = x + dx[idx], dy[idx]

    if a < 1 or b < 1 or a > n or b > n:
        continue

    x, y = a, b

print(x, y)