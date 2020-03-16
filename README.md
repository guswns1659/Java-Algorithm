# Java-Algorithm
자료구조 및 알고리즘 공부 및 문제풀이 저장소

## 생성 이유 
[Do it 자료구조와 함께 배우는 알고리즘 자바편](http://m.yes24.com/goods/detail/60547893)을 읽으며 자료구조의 개념을 세웠다. 이젠 문제 풀이 시작!! 

## [leetCode Easy](https://leetcode.com/)
1. [Roman to Integer](https://leetcode.com/problems/roman-to-integer/)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/blob/master/src/leetcodeEasy/RomanToInt.java)
    - HashMap, stack 이용해 문제 풀이
    - 테스트 시작 전 스택을 비워야함! 
2. [Valid Parentheses](https://leetcode.com/problems/roman-to-integer/)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/blob/master/src/leetcodeEasy/ValidBraket.java)
    - 브라켓의 유효성 확인하는 문제. 
    - HashMap, stack 이용해 문제 풀이
    - 테스 시작 전 스택 비우기!!
3. [Min Stack](https://leetcode.com/problems/min-stack/)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/blob/master/src/leetcodeEasy/MinStack.java)
    - 최솟값을 구하는 stack 자료구조 구현 문제.
    - 최솟값을 모아놓는 스택을 하나 더 구현해야 했는데, 나는 stream을 이용...   
4. [Majority Element](https://leetcode.com/problems/majority-element/)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/blob/master/src/leetcodeEasy/MajorityElement.java)
    - 배열 크기의 절반보다 빈도수가 많은 원소 구하기 
    - HashMap의 원소 값 추가하며 구현 : hashMap.merge(key, 1, Integer::sum);
    - more than의 의미는 초과!
5. [Count Primes](https://leetcode.com/problems/count-primes)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/blob/master/src/leetcodeEasy/CountPrimes.java)
    - 양의 정수 n이하 소수의 개수를 구하기
    - Arrays.asList()로 초기화하면 add, remove() 연산 시 unSupportedOperation 예외 발생 
    - Prime인지 계산할 때 <= 주의!! (어딘지 알지?)
## [leetCode Medium](https://leetcode.com/)
