# Java-Algorithm
자료구조 및 알고리즘 공부 및 문제풀이 저장소

## 생성 이유 
[Do it 자료구조와 함께 배우는 알고리즘 자바편](http://m.yes24.com/goods/detail/60547893)을 읽으며 자료구조의 개념을 세웠다. 이젠 문제 풀이 시작!! 

## 커밋 컨벤션
- [Docs] : README 문서에 풀이 정리
- [Algorithm] : 문제 풀이한 코드 커밋

## [leetCode Easy](https://leetcode.com/) / Total : 6문제
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
6. [Vaild Anagram](https://leetcode.com/problems/valid-anagram)
    - [풀이]()
    - 두 개의 문자열이 anagram인지 판별하는 문제 
    - char[]는 stream으로 사용하려면 복잡하다. 그냥 for문 쓰기.	
	- replaceFirst()와 replace의 차이는 여러개를 바꾸냐 마느냐의 차이다. 
    - 반복문으로 해결되는 데 굳이 스택을 사용..

## 백준 - 그리디 알고리즘 / Total : 4문제
1. [ATM](https://www.acmicpc.net/problem/11399)
 	- [풀이](https://github.com/guswns1659/Java-Algorithm/commit/b0a3fcff14f2c1e4151401a13bffa8746412a3ba)
	- [동빈나의 알고리즘 풀이전략](https://www.youtube.com/watch?v=ukkLCl9yBvE&t=806s) 영상 본 뒤 그리디 알고리즘 문제 풀이 시작 
	- 일주일만에 다시 알고리즘 공부 시작..! 하루에 한문제는 도전하기!
	- List sort는 Collection.sort() 이용.
2. [동전](https://www.acmicpc.net/problem/11047)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/commit/2e99259e63993451c3fd033342851c6942071085)
	- 금액을 주어진 동전들의 내림차순으로 나눈다. 나눈 몫이 0이 아닐 때 answer추가하고, 0이라면 다른 동전으로 나눈다. 
	- 나머지를 금액으로 초기화하고 반복한다. 
	- Intellij의 모든 code Completion을 끔.
	- 테스트 코드를 작성하지 못해 아쉽다. 
3. [거스름돈](https://www.acmicpc.net/problem/5585)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/commit/5ad82c12b845fa7ec2b0a64680b1588af91c6fb9)
	- 위의 동전문제와 동일 
4. [로프](https://www.acmicpc.net/problem/2217)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/commit/5f27ba9184cd9dabdeea455df95eb5cd0dcf7719)
	- 주어진 여러개의 로프로 들수 있는 최대 중량 구하는 문제 
	- 로프를 오름차순으로 정리한 뒤 작은 값부터 로프의 개수 -1를 곱한다. 
	- 곱한 값 중 최대값이 정답
	- List 오름차순은 Collections.sort(), 내림차순은 Collections.sort(list, Collections.reverseOrder());
## [leetCode Medium](https://leetcode.com/)
