import sys
sys.setrecursionlimit(8 ** 8)

n = int(input())
array = [[' '] * n for _ in range(n)]

def star(x, y, n):
    
    if n == 1:
        array[x][y] = '*'
        return 
        
    
    # 9 등분
    for i in range(3):
        for j in range(3):
            
            if i == 1 and j == 1:
                continue
            
            else:
                star(x + n // 3 * i, y + n // 3 * j, n // 3)

star(0, 0, n)

for i in range(n):
    for j in range(n):
        print(array[i][j], end='')
    print()