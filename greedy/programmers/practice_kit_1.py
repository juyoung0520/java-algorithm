def solution(n, lost, reserve):
    for i in reserve:
        if i in lost:
            reserve.remove(i)
            lost.remove(i)
    
    for i in reserve:
        if i in lost: lost.remove(i)
        if i - 1 in lost:
            lost.remove(i - 1)
        elif i + 1 in lost:
            lost.remove(i + 1)
    
    return n - len(lost)

def solution1(n, lost, reserve):
    set_lost = set(lost)-set(reserve)
    set_reserve = set(reserve)-set(lost)
            
    for i in set_reserve:
        if i - 1 in set_lost:
            set_lost.remove(i - 1)
        elif i + 1 in set_lost:
            set_lost.remove(i + 1)
    
    return n - len(set_lost)

def solution2(n, lost, reserve):
    remove = [x for x in lost if x in reserve]
    for x in remove:
        lost.remove(x)
        reserve.remove(x)

    for x in reserve:
        if x-1 in lost:
            lost.remove(x-1)
        elif x+1 in lost:
            lost.remove(x+1)
            
    return n-len(lost)

print(solution(3, [3], [1]))