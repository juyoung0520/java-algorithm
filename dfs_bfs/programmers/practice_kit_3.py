import collections

# 다른 글자 1개인 단어 모인 배열 반환
def findDifferent(current, words):
    array = []

    for word in words:
        count = 0

        for c, w in zip(current, word):
            if c != w:
                count += 1
        
        if count == 1:
            array.append(word)
    
    return array

def solution(begin, target, words):
    # 타깃 words에 없으면 리턴 0
    if not target in words:
        return 0
    # 각 단어의 거리를 값으로 갖는 딕셔너리
    dist = {begin: 0}
    que = collections.deque([begin])
    # 각 단어까지의 거리를 구하면서 BFS
    while que:
        current = que.popleft()

        for word in findDifferent(current, words):
            if word not in dist:
                dist[word] = dist[current] + 1
                que.append(word)
    # 타깃의 거리 반환   
    return dist.get(target)