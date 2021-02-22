def solution(phoneBook):
    phoneBook = sorted(phoneBook)

    for p1, p2 in zip(phoneBook, phoneBook[1:]):
        # 정렬했기 때문에 접두사 있으면 바로 뒤
        if p2.startswith(p1):
            return False
    return True

def solution2(phoneBook):
    # 전화번호 모두 딕셔너리에 추가
    dic = {p : 0 for p in phoneBook}

    for p in phoneBook:
        temp = ""
        
        for num in  p:
            # 각 전화번호의 글자 하나씩 추가해봄
            temp += num

            # 추가했을 때 딕셔너리에 있고 자신의 전화번호와 같지 않으면
            if temp in dic and temp != p:
                return False
    return True