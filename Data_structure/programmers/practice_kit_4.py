from collections import defaultdict

def solution(genres, plays):
    dic_plays = defaultdict(list)
    dic_sum = defaultdict(lambda: 0)
    
    for i, (g, p) in enumerate(zip(genres, plays)):
        dic_plays[g].append((i, p))
        dic_sum[g] += p
    
    answer = []
    # 첫번째 for - dic_sum 정렬, 합계 큰 순으로 키 정렬
    # 두번째 for - dic_plays[장르] 정렬, 장르별 플레이 많은 순, 같으면 인덱스 작은 순 정렬
    for (k, v) in sorted(dic_sum.items(), key=lambda x: x[1], reverse=True):
        for (i, p) in sorted(dic_plays[k], key=lambda x: (-x[1], x[0]))[:2]:
            answer.append(i)

    # sortDic = sorted(dic_sum.items(), key = lambda x: x[1], reverse=True)
    # answer = []
    # for k, v in sortDic:
    #     dic_plays[k] = sorted(dic_plays[k], key = lambda x: (-x[1], x[0]))
    #     answer += [i for (i, p) in dic_plays[k][:2]]

    return answer