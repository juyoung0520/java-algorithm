# 왕실 나이트
# a1 - 1행 a열
night = input()
row = int(night[1])
# 체스에서 열 a, b, c, d...
# ord - ACSII
colum = int(ord(night[0])) - int(ord('a')) + 1

steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

result = 0
for step in steps:
    a, b = row + step[0], colum + step[1]

    if a >= 1 and a <= 8 and b >= 1 and b <=8:
        result += 1

print(result)
