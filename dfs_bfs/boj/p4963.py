from sys import stdin
import sys
sys.setrecursionlimit(10000)

def dfs(array, h, w, x, y, visited):
    visited[x][y] = 1

    # 상하좌우 대각선
    dx = [0, 0, -1, 1, -1, 1, -1, 1]
    dy = [-1, 1, 0, 0, -1, 1, 1, -1]

    for i in range(8):
        a = x + dx[i]
        b = y + dy[i]
        
        if (0 <= a < h) and (0 <= b < w) and visited[a][b] == 0 and array[a][b] == 1:
            visited[a][b] = 1
            dfs(array, h, w, a, b, visited)

while True:
    w, h = map(int, stdin.readline().split())
    if w == 0 and h == 0:
        break

    array = []
    visited = [[0] * w for _ in range(h)]
    for i in range(h):
        array.append(list(map(int, stdin.readline().split())))
    
    count = 0
    for i in range(h):
        for j in range(w):
            if visited[i][j] == 0 and array[i][j] == 1:
                dfs(array, h, w, i, j, visited)    
                count += 1

    print(count)

    #visited 안쓰고 인접 섬 방문하면 0으로 바꿔줘도 됨!
