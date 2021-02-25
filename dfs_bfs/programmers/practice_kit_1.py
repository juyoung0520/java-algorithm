def dfs(i, sum, numbers, target):
    answer = 0
    
    if i == len(numbers):
        # 끝 부분에 도달하였을 때 합계가 target이면
        if sum == target:
            return 1
        return 0

    answer += dfs(i + 1, sum + numbers[i], numbers, target)
    answer += dfs(i + 1, sum - numbers[i], numbers, target)
    
    return answer

def solution(numbers, target):
    answer = 0
    answer += dfs(0, 0, numbers, target)
    return answer