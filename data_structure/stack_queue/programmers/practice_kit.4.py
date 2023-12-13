from collections import deque

def solution(priorities, location):
    answer = 0
    que = deque([(i, v) for i, v in enumerate(priorities)])

    while que:
        item = que.popleft()
        if any(item[1] < q[1] for q in que):
            que.append(item)
        else:
            answer += 1
            if item[0] == location:
                break
    
    return answer


solution([2, 1, 3, 2], 2)