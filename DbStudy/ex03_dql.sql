DROP DATABASE IF EXISTS company_db;
CREATE DATABASE IF NOT EXISTS company_db;

select * from employees;

USE company_db;

DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

CREATE TABLE IF NOT EXISTS departments
(
    dept_id     INT NOT NULL AUTO_INCREMENT COMMENT '부서아이디',
    dept_name   VARCHAR(30) COMMENT '부서명',
    location    VARCHAR(50) COMMENT '위치',
    CONSTRAINT pk_dept PRIMARY KEY(dept_id)
) ENGINE=InnoDB COMMENT '부서';

CREATE TABLE IF NOT EXISTS employees
(
    emp_id      INT NOT NULL AUTO_INCREMENT COMMENT '사원아이디',
    dept_id     INT COMMENT '부서아이디',
    emp_name    VARCHAR(15) COMMENT '사원명',
    position    CHAR(10) COMMENT '직급',
    gender      CHAR(1) COMMENT '성별',
    hire_date   DATE COMMENT '입사일자',
    salary      INT COMMENT '연봉',
    CONSTRAINT pk_emp PRIMARY KEY(emp_id),
    CONSTRAINT fk_dept_emp FOREIGN KEY(dept_id) 
      REFERENCES departments(dept_id)
) ENGINE=InnoDB COMMENT '사원';

ALTER TABLE employees AUTO_INCREMENT = 1001;

INSERT INTO departments(dept_name, location) VALUES ('영업부', '대구');
INSERT INTO departments(dept_name, location) VALUES ('인사부', '서울');
INSERT INTO departments(dept_name, location) VALUES ('총무부', '대구');
INSERT INTO departments(dept_name, location) VALUES ('기획부', '서울');

INSERT INTO employees VALUES (NULL, 1, '구창민', '과장', 'M', '95-05-01', 5000000);
INSERT INTO employees VALUES (NULL, 1, '김민서', '사원', 'M', '17-09-01', 2500000);
INSERT INTO employees VALUES (NULL, 2, '이은영', '부장', 'F', '90-09-01', 5500000);
INSERT INTO employees VALUES (NULL, 2, '한성일', '과장', 'M', '93-04-01', 5000000);

-- 대구에 있는 부서 조회하기

SELECT dept_name as '부서명'
FROM departments
where location = '대구';

-- 부서번호가 1이고 급여가 300만원인 사원 조회하기
SELECT emp_name AS 사원명, salary as 급여, dept_id as 부서번호
FROM employees e
WHERE salary >= 3000000 and dept_id = 1;
  
-- 급여가 300 만에서 500만 사이인 사원 조회하기
SELECT emp_name, salary AS 사원명
FROM employees
WHERE salary BETWEEN 3000000 and 5000000;

-- 직급이 과장 부장인 사원조회
SELECT emp_name AS 사원명
FROM employees e
WHERE position in ('과장','부장');

-- 직급이 과장 부장이 아닌 사원 조회
SELECT emp_name AS 사원명
FROM employees e
WHERE position not in ('과장','부장');

-- 이름이 한으로 시작하는 사원
SELECT emp_name AS 사원명
FROM employees e
WHERE emp_name like '한%';

 
SELECT emp_id, dept_id, emp_name, position, gender, hire_date, salary
FROM employees
WHERE emp_name LIKE CONCAT('한', '%');

-- 한을 포함하는 사원
SELECT emp_id, dept_id, emp_name, position, gender, hire_date, salary
FROM employees
WHERE emp_name LIKE CONCAT('%', '한', '%');

SELECT emp_id, dept_id, emp_name, position, gender, hire_date, salary
FROM employees
WHERE emp_name LIKE CONCAT('%', CONCAT('한', '%'));

-- 검색어를 변수로 받을 때 유용
SET @keyword = '한';

SELECT * FROM employees
WHERE emp_name LIKE CONCAT('%', @keyword, '%');


-- GROUP BY 절 실습
-- 직급별 평균
SELECT position, AVG(salary)
FROM employees
GROUP BY position;

-- 부서별 사원수 조회하기
SELECT dept_id as 부서번호, count(*) as 사원수 -- 모든 칼럼 중 어느 한 칼럼이라도 값을 가지고 있으면 count에 포함해줌
FROM employees
GROUP BY dept_id;

-- 직급이 과장인 사원 수 조회하기
SELECT position as 직급, COUNT(*) as 사원수
FROM employees
WHERE position = '과장'
GROUP BY position;

-- 급여 평균이 5000000 이상인 직급, 급여평균 조회
SELECT position as 직급, AVG(salary) as 급여평균
FROM employees
GROUP BY position
HAVING AVG(salary) >= 5000000;

SELECT position as 직급, AVG(salary) as salary_avg
FROM employees
GROUP BY position
HAVING salary_avg >= 5000000; -- mysql은 예외적으로 selecet 절의 별명을 having에서 사용 가능

-- ORDER BY + LIMIT
-- 높은 급여 순
SELECT emp_id, dept_id, emp_name, position, gender, hire_date, salary
FROM employees
ORDER BY salary DESC;

-- 가장 급여 높은 사람
SELECT emp_id, dept_id, emp_name, position, gender, hire_date, salary
FROM employees
ORDER BY salary DESC
LIMIT 1;

SELECT emp_id, dept_id, emp_name, position, gender, hire_date, salary
FROM employees
ORDER BY salary DESC
LIMIT 0, 1;

-- INNER 조인

-- dept_id에 대해 모호성 오류 발생
SELECT e.emp_id, e.emp_name, d.dept_name, dept_id
FROM departments d
INNER JOIN employees e
ON d.dept_id = e.dept_id;


SELECT e.emp_id, e.emp_name, d.dept_name, d.dept_id
FROM departments d
INNER JOIN employees e
ON d.dept_id = e.dept_id;             

-- (1) 대구에 근무하는 사원 조회하기
SELECT e.emp_id, e.emp_name, d.dept_name, d.dept_id
FROM departments d
INNER JOIN employees e
ON d.dept_id = e.dept_id
WHERE d.location = '대구';

-- (2) 지역별로 근무중인 사원 수 조회하기
SELECT d.location as 지역명, count(*) as 사원수
FROM departments d
INNER JOIN employees e
ON d.dept_id = e.dept_id
GROUP BY d.location;

-- outer join
SELECT e.emp_id, e.emp_name, d.dept_name
FROM departments d
LEFT OUTER JOIN employees e
ON d.dept_id = e.dept_id;

-- 부서별 근무중 사원수 (근무 중인 사원이 없으면 0으로 조회하기)
-- 틀린 답
SELECT d.dept_name, count(*)
FROM departments d
LEFT OUTER JOIN employees e
ON d.dept_id = e.dept_id
GROUP BY d.dept_name;

-- 애매한 답 (1) 부서명을 조회할 수 없음
SELECT d.dept_id, count(e.emp_id) as 사원수
FROM departments d
LEFT OUTER JOIN employees e
ON d.dept_id = e.dept_id
GROUP BY d.dept_id;

-- 애매한 답 (2) id 식별자로 그룹핑을 안해서 데이터가 정확히 그룹화되지 않음
SELECT d.dept_name, count(e.emp_id) as 사원수
FROM departments d
LEFT OUTER JOIN employees e
ON d.dept_id = e.dept_id
GROUP BY d.dept_name;

-- 정답
SELECT d.dept_name, count(e.emp_id) as 사원수
FROM departments d
LEFT OUTER JOIN employees e
ON d.dept_id = e.dept_id
GROUP BY d.dept_id, d.dept_name;

-- 서브 쿼리

-- 중첩 서브쿼리(결과가 1개인 단일 행 서브쿼리)

-- 평균 급여 이상을 받는 사원 조회
SELECT * 
FROM employees 
WHERE salary > (SELECT AVG(salary) FROM employees);

-- 중첩 서브쿼리(결과가 2개인 단일 행 서브쿼리)

-- SELECT * 
-- FROM employees 
-- WHERE dept_id = '영업부'의 dept_id 조회


SELECT * 
FROM employees 
WHERE dept_id in ( SELECT dept_id FROM departments WHERE dept_name in ('영업부','인사부'));



