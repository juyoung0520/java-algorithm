import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]

def solution2(participant, completion):
    temp = 0
    dic = {}

    for p in participant:
        dic[hash(p)] = p
        # 참가자 해시값 다 더함
        temp += int(hash(p))

    for c in completion:
        # 참가자 해시값 다 더한 거에서 완주자 해시 값 빼기
        temp -= int(hash(c))

    # 남은 한명 해시값 
    return dic[temp]

def solution3(participant, completion):
    participant.sort()
    completion.sort()

    for p, c in zip(participant, completion):
        if p != c:
            return p
        return participant[-1]

participant = ["leo", "kiki", "eden"]
completion = ["kiki", "eden"]

print(solution(participant, completion))
print(solution2(participant, completion))
print(solution3(participant, completion))
