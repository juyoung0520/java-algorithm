import sys

def binarySearch(cards, num, start, end):
    if start > end:
        print(0, end=' ')
        return None
    
    mid = (start + end) // 2

    if cards[mid] == num:
        print(1, end=' ')
        return mid
    elif cards[mid] < num:
        start = mid + 1   
    else:
        end = mid - 1

    binarySearch(cards, num, start, end)

n = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))
cards.sort() #소트 까먹지 말기

for i in array:
    binarySearch(cards, i, 0, n-1) 