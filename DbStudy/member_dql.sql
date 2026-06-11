use member_db;

select now() as 지금;

-- SELECT 절만 필수
SELECT 1 + 1;
SELECT NOW();

-- 칼럼 별명 (Alias)
SELECT NOW() AS 지금;

-- FROM 절: 테이블 조회
SELECT * FROM members;  -- *는 실무 사용 금지

-- 테이블 별명 (주로 조인/서브쿼리에서 필요)
SELECT m.mem_id, m.mem_name
FROM members m;

-- 중복 제거
SELECT DISTINCT addr FROM members;

-- WHERE 절: 조건 작성
SELECT mem_id, mem_name
FROM members
WHERE mem_id = '12345678';

SELECT mem_id, mem_name
FROM members
WHERE mem_name = '홍길동';