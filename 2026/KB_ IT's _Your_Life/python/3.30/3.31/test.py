def solution(my_string, n):
    return my_string[:n]

# 그냥 이렇게 쓰고 '재생 버튼' 누르는 게 제일 빠릅니다!
print(solution("ProgrammerS123", 11))

# 슬라이싱 ([:]) : 문자열이나 리스트 일부분을 가져올 때
# [:n]: 0부터 n번째 글자까지