def solution(prices):
    answer = [0] * len(prices)

    for i in range(len(prices)-1):
        for j in range(i, len(prices)-1):
            if prices[i] >prices[j]:
                break
            else:
                answer[i] +=1
    return answer

def solution2(prices):
    answer = [0] * len (prices)
    stack = []

    for i, price in enumerate(prices):
    # 증가하면 계속 스택에 넣다가 감소하면 가격 떧어진 애들의 '가격 떨어지지 않은 기간' 구하기
        while stack and price < prices[stack[-1]]:
            j = stack.pop()
            answer[j] = i - j
        # 인덱스 스택에 넣기
        stack.append(i)

    # 증가하기만 한 애들 '가격 떨어지지 않은 기간' 구하기
    while stack:
        j = stack.pop()
        answer[j] = len(prices) - j - 1
        
    return answer
