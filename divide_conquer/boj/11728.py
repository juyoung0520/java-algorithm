import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

print(' '.join(map(str, sorted(a + b)))) 
# join - 리스트의 문자열 합치기
# 문자열 사이 사이에 특정 문자열 넣고 싶으면 '특정 문자열'.join(리스트) 