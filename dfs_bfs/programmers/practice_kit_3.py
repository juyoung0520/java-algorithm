import collections

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
    if not target in words:
        return 0

    dist = {begin: 0}
    que = collections.deque([begin])

    while que:
        current = que.popleft()

        for word in findDifferent(current, words):
            if word not in dist:
                dist[word] = dist[current] + 1
                que.append(word)
        
    return dist.get(target)