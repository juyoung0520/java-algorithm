def solution(n, times):
    answer = 0
    start, end = 1, max(times) * n # 최소값과 최대값
    mid = (start + end) // 2

    while start <= end:
        mid = (start + end) // 2

        count = 0
        for time in times:
            # 총 실행시간을 각 심사 시간으로 나눴을 때 입국심사 할수 있는 사람 수
            count += mid // time
            if count >= n: break

        if count >= n:
            answer = mid
            end = mid - 1
        else:
            start = mid + 1

    return answer