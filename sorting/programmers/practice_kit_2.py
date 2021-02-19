# 가장 큰 수
def solution(numbers):
    # 숫자를 문자열로 변환
    num = list(map(str, numbers))
    # 문자의 공통된 부분의 아스키코드 값이 같으면 문자의 길이로 정렬된다.
    # 문자열의 길이가 더 짧은 문자를 더 큰 값으로 만들기 위해 문자를 늘려서 비교
    num.sort(key=lambda x: x*3, reverse=True)
    return str(int(''.join(num)))

print(solution([6,10,2]))