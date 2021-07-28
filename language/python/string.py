from sys import stdin
# 문자열 리스트로
n = '1234'
print(list(n))

# 문자열 개행, 공백 제거
# input함수는 개행 삭제하여 리턴
n = list(stdin.readline().strip())

#문자열 포맷 만들기
n = 2
str = f"저는 하루에 알고리즘 문제를 {n}개 풉니다."