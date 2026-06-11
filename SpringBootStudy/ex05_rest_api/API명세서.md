# API 명세

### 1. 회원 등록
- 요청: `POST /api/members`h 
- 요청 본문: {"email" : "user@example.com"}
- 응답 본문: 등록된 회원 정보(MemberResponse)
- 상태 코드: 201 Created

### 2. 회원 전체 조회
- 요청: GET /api/members
- 요청 본문: x
- 응답 본문: 회원 목록(List<MemberResponse>)
- 상태 코드: 200 ok

### 3. 회원 단건 조회
- 요청: GET /api/members/{id}
- 요청 본문: x
- 응답 본문: 단건 회원 정보 (MemberResponse)
- 상태 코드: 200 ok / 404 not found

### 4. 회원 수정
- 요청: PUT /api/members/{id}
- 요청 본문: {"email" : "user@example.com"}
- 응답 본문: 수정된 회원 정보(MemberResponse)
- 상태 코드: 200 OK

### 5. 회원 삭제
- 요청: DELETE /api/members/{id}
- 요청 본문: x
- 응답 본문: x
- 상태 코드: 204 no content

