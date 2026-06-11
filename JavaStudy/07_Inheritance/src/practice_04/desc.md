# practice_04 패키지 분석: 상속 + 다형성

## 클래스 구조 (상속 트리)

```
Person          ← 부모 클래스 (슈퍼클래스)
├── Man         ← 자식 클래스
└── Woman       ← 자식 클래스

Seat            ← Person을 "포함"하는 클래스 (컴포지션)
Bus             ← Seat[]를 관리하는 클래스
```

---

## 1. 상속 (Inheritance)

`Man.java`과 `Woman.java`은 `Person`을 `extends`합니다.

```java
// Man.java
public class Man extends Person {
    public Man(String name) {
        super(name);   // 부모 생성자 호출 — name 필드는 Person이 관리
    }
}
```

- `Man`과 `Woman`은 자체 필드가 없지만, `Person`의 `name`, `getName()`, `setName()`을 **그대로 물려받습니다.**
- `super(name)` → 부모 클래스의 생성자를 먼저 실행해서 `private String name`을 초기화합니다.

---

## 2. 다형성 (Polymorphism)

`Seat.java`와 `Bus.java`를 보세요.

```java
// Seat.java
private Person person;             // Man도, Woman도 여기 들어올 수 있다

public void setPerson(Person person) { ... }
```

```java
// Bus.java
public void on(Person person) {    // 매개변수 타입이 Person
    ...
    seats[i].setPerson(person);    // Man or Woman → Person 참조변수에 대입
}
```

`Main.java`에서 실제로 다형성이 작동합니다.

```java
bus.on(new Man("톰"));        // Man 객체  → Person 타입 매개변수로 전달 (업캐스팅)
bus.on(new Woman("제시카"));  // Woman 객체 → Person 타입 매개변수로 전달 (업캐스팅)
```

> `Man`과 `Woman`은 서로 다른 타입이지만, 둘 다 `Person`의 자식이므로  
> **`on(Person person)` 하나의 메서드로 처리 가능합니다.** 이게 다형성의 핵심입니다.

---

## 3. 전체 흐름 요약

```
Main
│
├─ Bus(5)                        ← Seat 5개 생성 (각 seats[i] = new Seat())
│
├─ bus.on(new Man("톰"))
│       └─ Man → Person으로 업캐스팅
│          seats[0].setPerson(person) 저장
│
├─ bus.on(new Woman("제시카"))   ← Man이든 Woman이든 동일한 메서드로 처리
│       └─ Woman → Person으로 업캐스팅
│          빈 좌석 탐색 후 저장
│
├─ bus.off(3)                    ← seats[2].setPerson(null)
│
└─ bus.info()                    ← seats[i].getPerson()으로 Person 꺼내서 이름 출력
```

---

## 핵심 정리

| 개념 | 코드에서 어디 | 설명 |
|------|-------------|------|
| 상속 | `Man extends Person` | `Person`의 필드·메서드를 재사용 |
| 업캐스팅 | `bus.on(new Man(...))` | 자식 → 부모 타입으로 자동 변환 |
| 다형성 | `on(Person person)` | `Man`/`Woman` 구분 없이 하나의 메서드로 처리 |
| 컴포지션 | `Seat`의 `Person person` 필드 | `Seat`가 `Person`을 "포함"함 |

> `Seat`의 `person` 필드가 `Person` 타입이기 때문에,  
> 나중에 `Child` 같은 새 자식 클래스를 추가해도 **`Bus`와 `Seat` 코드를 전혀 수정하지 않아도 됩니다.**  
> 이것이 상속 + 다형성을 쓰는 가장 큰 이유입니다.
