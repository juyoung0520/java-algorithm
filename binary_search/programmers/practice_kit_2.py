def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    dist = [rocks[0], rocks[-1]]

    for a, b in len(rocks):
        dist.append(b - a)
    
    start, end = min(dist), max(dist)

    for r in len(rocks):
        del()




    return answer