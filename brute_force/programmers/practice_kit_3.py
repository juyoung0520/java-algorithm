def solution(brown, yellow):
    answer = []
    total = brown + yellow

    for a in range(total + 1, 1, -1):
        
        if total % a != 0:
            continue
        
        b = total // a
        # (a-1 + b -1) * 2
        br = 2 * (a + b - 2)
        ye = (a - 2) * (b - 2)

        if br == brown and ye == yellow:
            return [a, b]
        
    return answer
