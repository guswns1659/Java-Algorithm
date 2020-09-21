# Java-Algorithm
자료구조 및 알고리즘 공부 및 문제풀이 저장소

## 생성 이유 
[Do it 자료구조와 함께 배우는 알고리즘 자바편](http://m.yes24.com/goods/detail/60547893)을 읽으며 자료구조의 개념을 세웠다. 이젠 문제 풀이 시작!! 

## 커밋 컨벤션
- [Docs] : README 문서에 풀이 정리
- [Algorithm] : 문제 풀이한 코드 커밋

<details markdown="1">
<summary>구현</summary>

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
    - [풀이](https://github.com/guswns1659/Java-Algorithm/blob/master/src/leetcodeEasy/VaildAnagram.java)
    - 두 개의 문자열이 anagram인지 판별하는 문제 
    - char[]는 stream으로 사용하려면 복잡하다. 그냥 for문 쓰기.	
	- replaceFirst()와 replace의 차이는 여러개를 바꾸냐 마느냐의 차이다. 
    - 반복문으로 해결되는 데 굳이 스택을 사용..
7. [나머지 한 점](https://programmers.co.kr/learn/courses/18)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/31)
    - 직사각형의 나머지 한점을 구하는 문제. 
    - 해시를 사용했지만 XOR를 이용하면 A, B, B 있을 때 A를 구하기가 쉽다. 
8. [방 번호](https://www.acmicpc.net/problem/1475)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/40)

</details>

<details markdown="1">
<summary>정렬</summary>

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
5. [30](https://www.acmicpc.net/problem/10610) 
	- [풀이](https://github.com/guswns1659/Java-Algorithm/commit/51a78650334be10040298392c463b7cd870d46b8)
	- 주어진 숫자의 자리수로 가장 큰 30의 배수를 출력, 만들 수 없다면 -1 출력 문제.
	- 자리수에 0이 없는지, 더한 자리수가 3의 배수인지로 확인 가능.
	- 풀이보다 자바 문법익히는 데 시간이 더 걸림. 꾸준히해야 몸에 익을 거 같다.
	- split("") 하면 한 단어씩 끊어진다.
	- 기본형 배열 sort : Arrays.sort() / 역순 : Arrays.sort(list, Collections.reverseOrder()); 다만, 기본자료형 배열은 역순이 안된다.
6. [인턴](https://www.acmicpc.net/problem/2875)
	- [풀이실패](https://github.com/guswns1659/Java-Algorithm/blob/5797e2a98810cffbdcb833136f3f5d2fcd47e7ee/src/backjun/Intern.java)
	- 주어진 남,녀,인턴 참가자로 만들 수 있는 최대 팀 수 구하는 문제 
	- 남 1, 여 2으로 2인 1조. 인턴 참가자는 제외하고 계산해야함.
	- 설계를 잘 못 했는지 반례가 계속 나온다. 추후 도전
7. [잃어버린 괄호](https://www.acmicpc.net/problem/1541)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/commit/f8c73d1d2173bb921cedeca6666c3d90fb8657dc)
	- 괄호가 없는 수식에서 괄호를 사용해서 최소값을 만드는 문제 
	- "+"를 split하려면 split("\\+")라고 적어야함. 예약된 문자라 그렇다고 함. 
	- "-"를 기준으로 괄호를 만들면 된다. 
8. [기타줄](https://www.acmicpc.net/problem/1049)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/master/src/backjun/GuitarString.java)
	- 구매할 기타줄을 패키지와 낱개 가격을 이용해서 최솟값으로 구매하는 문제 
	- 패키지와 낱개의 최솟값을 모은 뒤 아래 경우의 수로 계산해서 그 중 최솟값을 출력하기.
	- 3가지 경우
		- 패키지 최소값으로만 구하기 
		- 낱개로만 구하기
		- 두 개를 섞어서 구하기 
	- 스트림으로 최솟값을 구할 때 : candidate.stream().mapToInt(s -> s).min().getAsInt();
	- getAsInt()가 경고가 뜨는데 어떻게 처리할 지는 고민해보기. 
9. [부등호](https://www.acmicpc.net/problem/2529)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/master/src/backjun/Sign.java)
	- 입력된 값을 파싱하는 코드만 추가
	- 백트래킹, DFS, BFS와 관련된 문제라 개념 공부
	- 인터넷 답안보고 해결
10. [반도체 설계](https://www.acmicpc.net/problem/2352)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/60bf1f774bd9d05ea99e8bf34df1cf64c3fa10b2/src/backjun/N2352.java)
	- LIS(Longest Increasing Subsequence) 문제지만 길이만 같고 배열의 원소는 다름.
	- Arrays.binarySearch() 사용 시 원소가 없으면 들어갈 자리가 음수로 나온다. 대신 들어갈 자리 시작은 1부터 시작.
11. [줄세우기](https://www.acmicpc.net/problem/2631)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/ec8d86011b9983089486ce24ee251852dab19fc0/src/backjun/N2631.java)
	- LIS 변형 문제.
	- 아이들수 - (최장 증가 부분수열의 길이)
12. [먹이사슬](https://www.acmicpc.net/problem/2532)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/886a30ae86f040845d10bf0aa5a0b39aa0c91ea5/src/backjun/N2532.java)
	- LIS 변형 문제.
	- 최장 감소 길이 수열. 
	- 답을 봤지만 이해가 더 필요.
	- Comparable 구현할 때 오름차순일 경우, 값을 비교한 뒤 작으면 -1, 크면 +1. 
	- 내림차순일 경우 값을 비교한 뒤 작으면 +1, 크면 -1.
14. [k번째수](https://programmers.co.kr/learn/courses/30/lessons/42748)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/15)
    - 기본 배열의 정렬을 이해한다면 풀 문제. 	
15. [가장 큰 수](https://programmers.co.kr/learn/courses/30/lessons/42748)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/16)
    - Comparator를 잘 활용해서 풀어야하는 문제. 자릿수 별로 비교해 정렬하는 문제
16. [통계합](https://www.acmicpc.net/problem/2108)
    - [풀이](https://github.com/guswns1659/JuraJura/issues/66)

</details>

<details markdown="1">
<summary>전체탐색</summary>

> 문제 검색 : 문제 링크에 들어가서 각 문제 이름 검색하기 

1. [KiwiJuiceEasy](https://arena.topcoder.com/#/u/practiceCode/14359/13281/11020/2/305508)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/8241ac110e51009ddfdea24cb6f7fa9e65636586/src/topcoder/KiwiJuiceEasy.java)
	- 문제를 차근차근 이해하면서 문제 풀어 보기. 
2. [InterestingParty](https://arena.topcoder.com/#/u/practiceCode/14480/15196/11312/2/307028)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/8ca42c737d4ccbbf07b7a59cf68e77f54861085a/src/topcoder/InterestingParty.java)
	- Arrays.asList()로 List 만들면 add, remove 연산을 사용할 수 없다.
	- 기본 배열 합치려면 Collections으로 만들어야 한다. 
		- List<String> list = new ArrayList<>(Arrays.asList(first));
	- 주어진 배열을 합친 뒤 전체 탐색하는 문제. 
	- HashMap으로 문제 풀이 가능.
3. [Cryptography](https://arena.topcoder.com/#/u/practiceCode/14365/11262/10814/2/305685)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/aee0436dac15f8dfcd64bc6473d80d14bc3ccf46/src/topcoder/Cryptography.java)
	- 전체 탐색 문제
4. [ThePalindrome](https://arena.topcoder.com/#/u/practiceCode/13690/9026/10182/2/299600)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/fdebb0716cf6c5f799c5c644477fc226fb3a96e1/src/topcoder/ThePalindrome.java)
	- 전체 탐색 문제. 
	- 테스트 코드와 디버거의 힘을 알 수 있었던 문제.
5. [FriendScore](https://arena.topcoder.com/#/u/practiceCode/13785/9172/10343/2/300637) 
	- [풀이](https://github.com/guswns1659/Java-Algorithm/blob/37caba2b8d2f2a08e580930a0acb89cf75f66e02/src/topcoder/FriendScore.java)
	- 전체 탐색 문제. 
	- 문제 이해를 위해 그래프를 그려봄.
6. [전화번호 목록](https://programmers.co.kr/learn/courses/30/lessons/42577)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/10)
7. [트리 순회](https://www.acmicpc.net/problem/1991)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/21)
8. [분해합](https://www.acmicpc.net/problem/2231)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/33)
9. [한 줄로 서기](https://www.acmicpc.net/problem/1138)
   	- [풀이]()
10. [덩치](https://www.acmicpc.net/problem/7568)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/34)
11. [영화감독 숌](https://www.acmicpc.net/problem/1436)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/38)
	
</details>

<details markdown="1">
<summary>이진탐색</summary>

1. [공유기설치](https://www.acmicpc.net/problem/2110)
	- [풀이](https://github.com/guswns1659/Java-Algorithm/issues/1)
2. [나무자르기](https://www.acmicpc.net/problem/2805)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/2)
3. [숫자카드](https://www.acmicpc.net/problem/10815)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/3)
4. [랜선자르기](https://www.acmicpc.net/problem/1654)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/4)

</details>

<details markdown="1">
<summary>문자열</summary>

1. [괄호](https://www.acmicpc.net/problem/9012)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/7)
    - 스택 이용해서 푸는 괄호 문제
2. [IOIOI](https://www.acmicpc.net/problem/5525)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/8)
    - 문자열 패턴 알고리즘 문제 

</details>

<details markdown="1">
<summary>DFS/BFS</summary>

1. [타켓넘버](https://programmers.co.kr/learn/courses/30/lessons/43165)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/11)
    - BFS 기본 문제. 개념만으로는 풀 수 없고 응용을 해야 한다.
2. [네트워크](https://programmers.co.kr/learn/courses/30/lessons/43162)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/12)
    - Union-Find를 이용한 문제.
3. [DFS와 BFS](https://www.acmicpc.net/problem/1260)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/13)
    - 주어진 정점간의 관계를 이차원 배열로 표현한 뒤 dfs, bfs
4. [바이러스](https://www.acmicpc.net/problem/2606)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/14)
    - Union-Find를 조금 응용한 문제
5. [미로찾기](https://www.acmicpc.net/problem/2178)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/22)
    - DFS를 큐로 구현하는 기본 문제
6. [그림](https://www.acmicpc.net/problem/1926)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/24)
    - DFS를 응용한 문제
7. [토마토](https://www.acmicpc.net/problem/7576)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/25)
    - 여러 시작점이 있는 DFS 문제
8. [불!](https://www.acmicpc.net/problem/4179)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/27)
    - 시작점이 다른 종류인 DFS 문제
9. [숨바꼭질](https://www.acmicpc.net/problem/1697)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/28)
    - 1차원 배열 BFS 문제
10. [단지번호붙이기](https://www.acmicpc.net/problem/2667)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/30)
    - 여러 시작점이 있지만 서로 구분해야 하는 문제
11. [적록색약](https://www.acmicpc.net/problem/10026)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/32)
    - 여러 시작점이 있고 시작점의 유형을 구분해야 하는 문제 
12. [CrazyBot](https://arena.topcoder.com/#/u/practiceProblemList) 
  	- [풀이](https://github.com/guswns1659/Java-Algorithm/commit/dabd86c2d42131b2af45e1ac87dc3104809af622)
   	- DFS이용한 전체 탐색 문제.
   	- 좌표 방향에 대한 이해가 오래걸렸던 문제.
13. [유기농배추](https://www.acmicpc.net/problem/1012)
    - [풀이](https://github.com/guswns1659/Java-Algorithm/issues/35)
    - 가로가 먼저 입력되니까 행과 열을 반대로 잘 처리해야하는 문제

</details>

