import sys
from bisect import bisect_right, bisect_left

def countNum(cards, num):
    left = bisect_left(cards, num)
    right = bisect_right(cards, num)
    return right - left

def binarySearch(cards, num):
    start = 0
    end = len(cards) - 1
    count = 0

    while start <= end:
        mid = start + end // 2

        if cards[mid] == num:
            count += 1
        elif cards[mid] > num:
            end = mid - 1
        else:
            start = mid + 1
    
    return count

n = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
cards.sort()

for i in list(map(int, sys.stdin.readline().split())):
    print(binarySearch(cards, i), end=' ')