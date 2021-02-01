import sys
from bisect import bisect_right, bisect_left

def countNum(cards, num):
    left = bisect_left(cards, num)
    right = bisect_right(cards, num)
    return right - left

n = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
cards.sort()

for i in list(map(int, sys.stdin.readline().split())):
    print(countNum(cards, i), end=' ')