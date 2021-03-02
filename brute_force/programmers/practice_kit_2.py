import itertools 

def solution(numbers):
    answer = 0
    num = []
    
    for i in range(1, len(numbers) + 1):
        # n 개에서 i개 뽑을 때의 순열 
        # permutation 객체 반환. 튜플들로 구성된 객체 
        pm = itertools.permutations(numbers, i)
        # 각 경우가 튜플로 되어있으므로 합치고, int로 바꾸기
        for n in map(int, map(''.join, pm)):
            num.append(n)

    # 숫자가 같을 경우가 있으면 중복 발생하므로 중복제거
    num = set(num)
    # 소수 아닌 경우 카운트
    for n in num:
        if n <= 1:
            answer += 1
            continue

        for i in range(2, n):
            if n % i == 0:
                answer += 1
                break

    return len(num) - answer