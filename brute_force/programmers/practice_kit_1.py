def solution(answers):
    giveUp = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    score = [0] * len(giveUp)

    for i in range(len(giveUp)):
        for j in range(len(answers)):

            idx = j % len(giveUp[i])
            if answers[j] == giveUp[i][idx]:
                score[i] += 1
    
    answer = []
    for i in range(len(score)):
        if score[i] == max(score):
            answer.append(i + 1)

    return sorted(answer)

print(solution([1,3,2,4,2]))