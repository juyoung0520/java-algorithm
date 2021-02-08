import sys
input = sys.stdin.readline

n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]
result = [0] * 3

def check(x, y, n):
    # 다른 원소들 확진. n이 계속 달라짐.
    for i in range(x, x+n):
        for j in range(y, y+n):
            # 첫 원소랑 비교해서 다르면 9등분
            if matrix[i][j] != matrix[x][y]:
                # 나눈 9개의 리스트 확인
                for k in range(3):
                    for l in range(3):
                        check(x + n // 3 * k, y + n // 3 * l, n // 3)
                # 9개로 나누고 리턴
                return
    
    # 9개로 안나누고 끝나면 모든 원소 같다는 뜻
    result[matrix[x][y]] += 1

check(0, 0, n)
# -1은 인덱스 2
for i in range(-1, 2):
    print(result[i])
