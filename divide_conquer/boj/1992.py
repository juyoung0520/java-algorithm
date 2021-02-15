import sys
input = sys.stdin.readline

n = int(input())
array = [list((map(int, input().strip()))) for _ in range(n)]

def divide(x, y, n):

    for i in range(x, x+n):
        for j in range(y, y+n):
            if array[i][j] != array[x][y]:
                print('(', end='')

                for k in range(2):
                    for l in range(2):
                        divide(x + n // 2 * k, y + n // 2 * l , n // 2)

                print(')',end='')
                return
    print(array[x][y],end='')

divide(0, 0, n)
            
    
    