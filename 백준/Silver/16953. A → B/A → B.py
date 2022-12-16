from collections import deque
A,B=map(int,input().split())

queue=deque()
queue.append((A,1)) # 이렇게 넣어야 deque([(2,1)])이렇게 값이 나와서 popleft가 가능해짐

answer=0
while queue:
    a, now =queue.popleft()
    if a == B:
        answer = now
        break
    if a> B:
        continue
    queue.append((a*2,now+1))
    queue.append((int(str(a)+'1') , now + 1))
print(-1 if answer==0 else answer)