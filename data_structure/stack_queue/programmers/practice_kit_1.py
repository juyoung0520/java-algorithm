from collections import deque

def solution(bridge_length, weight, truck_weights):
    time = 0
    # 다리 길이 만큼 0으로 채워두기
    bridge = [0] * bridge_length

    while bridge:
        time += 1
        # 맨 앞 트럭 빼기
        bridge.popleft()
        
        if truck_weights:
            if sum(bridge) + truck_weights[0] <= weight:
                bridge.append(truck_weights.pop(0))
            else:
                # 추가한 무게가 weight 넘으면 0 넣어준다
                bridge.append(0)
        
        return time