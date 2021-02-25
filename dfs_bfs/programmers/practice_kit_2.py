def dfs(v, computers, visited):
    visited[v] = True

    for i in range(len(visited)):
        # 인접 컴퓨터 중에 방문하지 않은것 방문
        if visited[i] == False and computers[v][i] == 1:
            dfs(i, computers, visited)

def solution(n, computers):
    visited = [False * (n + 1)]
    count = 0

    for i in range(n + 1):
        # 총 연결 요소 개수 구하기
        if visited[i] == False:
            dfs(i, computers, visited)
            count += 1
            
    return count