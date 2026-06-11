USE company_db;

-- 내부 조인: 두 테이블에 모두 존재하는 것만 조회

-- 사원아이디, 사원명, 부서명 조회하기
SELECT e.emp_id, e.emp_name, d.dept_name
FROM departments d
INNER JOIN employees e
ON d.dept_id = e.dept_id;

-- '대구'에 근무하는 사원 조회하기
SELECT e.emp_id, e.dept_id, e.emp_name, e.position, e.gender, e.hire_date, e.salary, d.location
  FROM departments d INNER JOIN employees e
    ON d.dept_id = e.dept_id
 WHERE d.location = '대구';

-- 지역별로 근무 중인 사원 수 조회하기
SELECT d.location AS 지역
     , COUNT(*)   AS "사원 수"
  FROM departments d INNER JOIN employees e
    ON d.dept_id = e.dept_id
 GROUP BY d.location;


-- 외부 조인: 두 테이블 중 한 곳에만 있는 데이터도 함께 조회하기

-- 사원아이디, 사원명, 부서명 조회하기(근무 중인 사원이 없는 부서도 함께 조회하기)
SELECT e.emp_id, e.emp_name, d.dept_name
FROM departments d
LEFT OUTER JOIN employees e
ON d.dept_id = e.dept_id;

-- 부서별 사원 수 조회하기 (근무 중인 사원이 없으면 0으로 조회하기)
SELECT d.dept_name, COUNT(emp_id)
FROM departments d LEFT OUTER JOIN employees e
ON d.dept_id = e.dept_id
GROUP BY d.dept_id, d.dept_name;


-- 서브 쿼리

-- 중첩 서브쿼리(결과가 1개인 단일 행 서브쿼리)
SELECT * 
FROM employees 
WHERE salary > (SELECT AVG(salary) 
                FROM employees);

-- 중첩 서브쿼리(결과가 2개 이상인 다중 행 서브쿼리)
-- SELECT *
-- FROM employees
-- WHERE dept_id = ('영업부'의 dept_id 조회);

SELECT *
FROM employees
WHERE dept_id IN (SELECT dept_id
                  FROM departments
                  WHERE dept_name = '영업부');
