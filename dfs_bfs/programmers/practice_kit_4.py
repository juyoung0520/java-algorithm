import collections

def solution(tickets):
    answer = []
    city = collections.defaultdict(lambda: [])
    
    for start, end in tickets:
        city[start].append(end)
    
    # 스택 뒤에서 부터 뽑기 위해
    for v in city.values():
        v.sort(reverse=True)
        
    stack = ["ICN"]
    
    while stack:
        c = stack[-1]
        
        if c in city and city[c]:
            stack.append(city[c].pop())
        else:
            # 알파벳 순으로 방문했을때 전체를 못 도는 경우 맨 마지막으로 보내고 다시 방문
            answer.append(stack.pop())
    
    # 파이썬 역순 출력
    return answer[::-1]