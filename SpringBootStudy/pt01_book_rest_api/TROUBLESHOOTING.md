# Troubleshooting Record

## 1. 타입명 오타 — `Bookdto` → `BookDto`

**파일**: `BookController.java:34`

**증상**: 컴파일 오류

**원인**: `updateBook` 메소드의 반환 타입 제네릭에 오타

```java
// 오류
public ResponseEntity<Bookdto> updateBook(...)

// 수정
public ResponseEntity<BookDto> updateBook(...)
```

---

## 2. `@RequestBody` 누락 — 400 Bad Request

**파일**: `BookController.java:29`

**증상**:
```
status: 400
error: Bad Request
MethodArgumentNotValidException: Validation failed for argument [0]
```

**원인**: `saveBook` 파라미터에 `@RequestBody`가 없어 HTTP request body가 `BookDto`로 역직렬화되지 않음

```java
// 오류
public ResponseEntity<BookDto> saveBook(BookDto newBookDto)

// 수정
public ResponseEntity<BookDto> saveBook(@RequestBody BookDto newBookDto)
```

---

## 3. `@PathVariable` 누락 — 500 NullPointerException

**파일**: `BookController.java:36`, `BookService.java:26`

**증상**:
```
status: 500
error: Internal Server Error
NullPointerException at ConcurrentHashMap.putVal
```

**원인**: `updateBook` 파라미터에 `@PathVariable`이 없어 URL의 `{isbn}` 값이 바인딩되지 않고 `null`로 전달됨.
`ConcurrentHashMap`은 null key를 허용하지 않아 NPE 발생.

```java
// 오류
public ResponseEntity<BookDto> updateBook(Long id, @RequestBody BookDto newBookDto)

// 수정
public ResponseEntity<BookDto> updateBook(@PathVariable Long isbn, @RequestBody BookDto newBookDto)
```

---

## 4. 포트 8080 충돌 — 서버 시작 불가

**증상**:
```
Identify and stop the process that's listening on port 8080
or configure this application to listen on another port.
```

**원인**: 이전에 실행된 Spring Boot 프로세스가 종료되지 않고 포트 8080을 점유

**해결**:
```powershell
# 점유 프로세스 확인
netstat -ano | findstr :8080

# 프로세스 강제 종료 (PID는 위 명령 결과에서 확인)
taskkill /PID <PID> /F
```
