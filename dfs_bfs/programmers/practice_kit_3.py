import collections

def solution(begin, target, words):
    if not target in words:
        return 0
    
    words.append(begin)
    counter = list(map(collections.Counter, words))
    array = [[0] * len(words) for _ in range(len(words))]
    visited = [0] * len(words)
    
    # 글자 두 개의 같지 않은 글자의 자리 수 리스트 
    for i in range(len(words)):
        for j in range(i, len(words)):
            if i != j:
                array[i][j] = len(counter[i] - counter[j])
                array[j][i] = array[i][j]

    stack = [begin]
    visited[words.index(begin)] = 1
    count = 0

    while stack:
        w = stack.pop()
        count += 1
        
        for i in range(len(words)):
            # 다른 글자 자리 개수 한 개이고 방문하지 않은 경우
            if array[words.index(w)][i] == 1 and visited[i] == 0:
            
                if words[i] == target:
                    return count

                visited[i] = 1
                stack.append(words[i])
        
    return 0

begin = "hit"
target = "cog"
words = ["hot", "dot", "dog", "lot", "log", "cog"]

print(solution(begin, target, words))