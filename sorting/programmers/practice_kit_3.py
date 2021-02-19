# H - Index
def solution(citations):
    citations.sort(reverse = True)
    answer = max(map(min, enumerate(citations, start = 1)))
    return answer

    # for index, h in enumerate(citations):
    #     # 0 이 가장 큰 경우 0 나오기 위해 start 0 부터
    #     if index >= h:
    #         return index
    # 리스트 전체 원소가 리스트 길이보다 클 경우 
    # return len(citations)