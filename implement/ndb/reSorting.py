# 문자열 재정렬
s = input()
result = []
num = 0

for c in s:
    # 알파벳인 경우 결과 리스트에 삽입
    if c.isalpha():
        result.append(c)
    # 숫자는 따로 더하기
    else:
        value += int(c)

result.sort()

if value != 0:
    result.append(str(value))

print(''.join(result))