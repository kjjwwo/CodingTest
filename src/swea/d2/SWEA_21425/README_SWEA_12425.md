# SWEA D2

## 21425. +=

### 📌 문제 유형

- 구현
- 반복문
- 시뮬레이션

---

### 💡 핵심 아이디어

두 수 `A`, `B` 중 **더 작은 값에 더 큰 값을 계속 더한다.**

둘 중 하나가 `N`을 초과하면 반복을 종료하고, 지금까지 연산한 횟수를 출력한다.

#### 예시

```text
A = 1, B = 2, N = 5

1 2
3 2    // A += B
3 5    // B += A
8 5    // A += B

→ A > N
→ 총 3회
```

핵심 로직:

```java
while (A <= N && B <= N) {
    if (A > B) {
        B += A;
    } else {
        A += B;
    }

    cnt++;
}
```

더 작은 값에 큰 값을 더하면서 두 수를 빠르게 증가시킨다.

---

### ⏱️ 시간 복잡도

두 값이 연산할 때마다 빠르게 증가하며, 피보나치 수열과 유사한 형태로 증가한다.

따라서 반복 횟수는 매우 적으며 대략 다음과 같이 볼 수 있다.

```text
O(log N)
```

---

### ☕ 사용한 Java 문법

#### BufferedReader

```java
BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

int T = Integer.parseInt(br.readLine());
```

`Scanner` 대신 `BufferedReader`를 사용하여 입력을 처리한다.

#### StringTokenizer

```java
StringTokenizer st = new StringTokenizer(br.readLine(), " ");

int A = Integer.parseInt(st.nextToken());
int B = Integer.parseInt(st.nextToken());
int N = Integer.parseInt(st.nextToken());
```

공백으로 구분된 여러 값을 각각 읽어올 때 사용한다.

#### StringBuilder

```java
StringBuilder sb = new StringBuilder();

sb.append(cnt).append('\n');

System.out.print(sb);
```

각 테스트 케이스마다 출력하지 않고 결과를 모아서 한 번에 출력한다.

---

### 🔍 코드 리뷰 및 보완점

#### 1. `while(true)` 대신 종료 조건을 직접 작성

기존 코드:

```java
while (true) {
    if (A > N) {
        break;
    } else if (B > N) {
        break;
    }

    // 연산
}
```

개선 코드:

```java
while (A <= N && B <= N) {
    // 연산
}
```

종료 조건이 명확한 경우 반복문의 조건식에 직접 작성하면 코드가 간결해지고 반복 조건을 쉽게 파악할 수 있다.

---

#### 2. `println()` 대신 `print()`

이미 `StringBuilder`에 줄바꿈을 추가하고 있다.

```java
sb.append(cnt).append('\n');
```

따라서 마지막에는

```java
System.out.print(sb);
```

를 사용하면 추가적인 줄바꿈 없이 결과를 출력할 수 있다.

---

#### 3. `"\n"` 대신 `'\n'`

기존 코드:

```java
sb.append(cnt).append("\n");
```

개선 코드:

```java
sb.append(cnt).append('\n');
```

문자 하나만 추가하는 경우 문자열 `"\n"` 대신 문자 `'\n'`을 사용할 수 있다.

---

### ✅ 최종 코드

```java
package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 21425. += (D2)
 */
public class SWEA_21425 {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int cnt = 0;

            while (A <= N && B <= N) {

                if (A > B) {
                    B += A;
                } else {
                    A += B;
                }

                cnt++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
```

---

### 📝 이번 문제에서 얻은 패턴

> **조건을 만족할 때까지 상태값을 반복적으로 갱신하는 시뮬레이션 문제**

기본적인 형태:

```java
while (반복 조건) {
    상태 갱신;
    횟수 증가;
}
```

#### 기억할 점

- 종료 조건이 명확하면 `while(true) + break`보다 `while(조건)`을 고려한다.
- 두 값을 비교하면서 특정 값을 반복적으로 갱신하는 구현 패턴에 익숙해진다.
- 공백으로 구분된 입력은 `StringTokenizer`로 처리한다.
- 여러 테스트 케이스의 결과는 `StringBuilder`에 모아서 출력한다.