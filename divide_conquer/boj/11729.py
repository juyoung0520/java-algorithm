def hanoi(n, start, end):
    # 1일 경우 출력
    if n == 1:
        print(start, end)
    else:
        # n - 1까지를 중간 지점으로 옮김 (1+2+3 = 6) 이므로 6에서 출발과 끝 지점 빼면 나머지
        hanoi(n - 1, start, 6 - start - end)
        # n번째를 도착지로 옮김
        print(start, end)
        # n - 1까지를 도착지로 옮김
        hanoi(n - 1, 6 - start - end, end)

n = int(input())
hanoi(n, 1, 3)