from math import ceil

def solution(progresses, speeds):
    answer = []
    que = list(map(lambda x: (ceil((100 - progresses[x]) / speeds[x])), range(len(progresses))))
    
    while que:
        count, n = 1, que.pop(0)

        while que:
            if que[0] > n:
                answer.append(count)
                break

            count += 1
            que.pop(0)

    answer.append(count)

    return answer