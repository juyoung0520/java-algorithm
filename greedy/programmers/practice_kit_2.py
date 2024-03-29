def solution(name):
    change = [min(ord(i) - ord('A'), ord('Z') - ord(i) + 1) for i in name]
    idx = 0
    answer = 0

    while True:
        answer += change[idx]
        change[idx] = 0

        if sum(change) ==  0:
            return answer
        
        left, right = 1, 1

        while change[idx - left] == 0 :
            left += 1
        while change[idx + right] == 0 :
            right += 1

        idx += -left if left < right else right
        answer += left if left < right else right