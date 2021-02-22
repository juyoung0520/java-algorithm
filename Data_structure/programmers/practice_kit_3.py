from collections import defaultdict

def solution(clothes):
    dic = defaultdict(lambda: [""])
    
    for (cloth, k) in clothes:
        dic[k].append(cloth)
    
    answer = 1
    for key in dic.keys():
        answer *= len(dic[key])

    return answer - 1