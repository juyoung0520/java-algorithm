# 3찾기 문제 
# 최대 24 * 60 * 60 = 86,400
# 파이썬 1초에 약 2,000만번의 연산

n = int(input())

count = 0
for i in range(n + 1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i) + str(j) + str(k):
                count += 1

print(count)