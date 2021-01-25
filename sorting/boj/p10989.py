# 최댓값 K가 정해져 있어서 공간복잡도 O(K)
# N은 10,000,000 인데 최대가 10,000이여서 계수정렬로 푸는게 이득~!

import sys

n = int(sys.stdin.readline())
array = [0]*10001 

for i in range(n):
    array[int(sys.stdin.readline())] += 1

for i in range(10001):
    if array[i] != 0:
        for j in range(array[i]):
            print(i)