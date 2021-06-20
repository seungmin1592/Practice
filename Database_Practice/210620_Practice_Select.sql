-- 2021.06.20

-- SQL 문제풀이
-- 복습 및 다시 풀어보기

-- SELECT문 활용

-- 1. 덧셈연산자를 이용하여 모든 사원에 대해서 $300의 급여 인상을 계산한 후 사원의 이름, 급여, 인상된 급여를 출력하시오.
SELECT ENAME, SAL, (SAL + 300) AS UPSAL
FROM EMP;

-- 2. 사원의 이름, 급여, 연간 총 수입을 총 수입이 많은 것부터 작은 순으로 출력하시오, 연간 총수입은 월급에 12를 곱한 후 $100의 상여금을 더해서 계산하시오.
SELECT ENAME, SAL, (SAL * 12 + 100) AS YSAL
FROM EMP
ORDER BY YSAL DESC
;

-- 3. 급여가 2000을 넘는 사원의 이름과 급여를 표현, 급여가 많은 것부터 작은 순으로 출력하시오.
SELECT ENAME, SAL
FROM EMP
WHERE SAL > 2000
ORDER BY SAL DESC
;

-- 4. 사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
SELECT ENAME, DEPTNO
FROM EMP
WHERE EMPNO = 7788
;

-- 5. 급여가 2000에서 3000 사이에 포함되지 않는 사원의 이름과 급여를 출력하시오.
SELECT ENAME, SAL
FROM EMP
WHERE SAL NOT BETWEEN 2000 AND 3000
;

-- 6. 1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원의 이름, 담당업무, 입사일을 출력하시오.
SELECT ENAME, JOB, HIREDATE
FROM EMP
WHERE HIREDATE BETWEEN '1981/02/20' AND '1981/05/01'
;

-- 7. 부서번호가 20 및 30에 속한 사원의 이름과 부서번호를 출력, 이름을 기준(내림차순)으로 영문자순으로 출력하시오.
SELECT ENAME, DEPTNO
FROM EMP
WHERE DEPTNO = 20 OR DEPTNO = 30
ORDER BY ENAME
;

UPDATE EMP
SET DEPTNO = 30
WHERE ENAME = 'KING'
;

-- 8. 사원의 급여가 2000에서 3000사이에 포함되고 부서번호가 20 또는 30인 사원의 이름, 급여와 부서번호를 출력, 이름순(오름차순)으로 출력하시오.
SELECT ENAME, SAL, DEPTNO 
FROM EMP
WHERE (SAL BETWEEN 2000 AND 3000) AND DEPTNO = 20 OR DEPTNO = 30
ORDER BY ENAME
;

-- 9. 1981년도에 입사한 사원의 이름과 입사일을 출력하시오. (like 연산자와 와일드카드 사용)
SELECT ENAME, HIREDATE
FROM EMP
WHERE HIREDATE LIKE '%81%'
;

-- 10. 관리자가 없는 사원의 이름과 담당 업무를 출력하시오.
SELECT ENAME, JOB
FROM EMP
WHERE MGR IS NULL
;

-- 11. 커미션을 받을 수 있는 자격이 되는 사원의 이름, 급여, 커미션을 출력하되 급여 및 커미션을 기준으로 내림차순 정렬하여 표시하시오.
SELECT ENAME, SAL, COMM
FROM EMP
WHERE COMM IS NOT NULL
ORDER BY SAL, COMM
;

-- 12. 이름의 세번째 문자가 R인 사원의 이름을 표시하시오.
SELECT ENAME
FROM EMP
WHERE ENAME LIKE '__R%'
;

-- 13. 이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오.
SELECT ENAME
FROM EMP
WHERE ENAME LIKE '%A%' AND ENAME LIKE '%B%'
;

-- 14. 담당업무가 CLERK, 또는 SALESMAN이면서 급여가 $1600, $950 또는 $1300이 아닌 사원의 이름, 담당업무, 급여를 출력하시오.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE JOB IN ('CLERK' , 'SALESMAN') AND SAL NOT IN(1600, 950, 1300)
;

-- 15. 커미션이 $500 이상인 사원의 이름과 급여 및 커미션을 출력하시오.
SELECT ENAME, SAL, COMM
FROM EMP
WHERE COMM >= 500
;
 

-- 추가 문제
-- 1. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
-- (1) 도서번호가 1인 도서의 이름
select bookname
from book
where bookid = 1
;


-- (2) 가격이 20,000원 이상인 도서의 이름
select bookname
from book
where price >= 20000
;

-- (3) 박지성의 총 구매액 (박지성의 고객번호는 1번으로 놓고 작성)
select sum(saleprice)
from orders
where custid = 1
;

-- (4) 박지성이 구매한 도서의 수(박지성의 고객 번호는 1번으로 놓고 작성)
select count(*)
from orders
where custid = 1
;

-- 2. 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

-- (1) 마당서점 도서의 총 개수
select count(*)
from book
;

-- (2) 마당서점에 도서를 출고하는 출판사의 총 개수
select count(distinct publisher)
from book
;

-- (3) 모든 고객의 이름, 주소
select name, address
from customer
;

-- (4) 2014년7월4일 ~ 7월7일 사이에 주문 받은 도서의 주문 번호
select orderid
from orders
where orderdate between '14/07/01' and '14/07/07'
;

-- (5) 2014년7월4일 ~ 7월7일 사이에 주문받은 도서를 제외한 도서의 주문 번호
select orderid
from orders
where orderdate not between '14/07/01' and '14/07/07'
;


-- (6) 성이 ‘김’씨인 고객의 이름과 주소
select name, address
from customer
where name like '김%'
;

-- (7) 성이 ‘김’씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
select name, address
from customer
where name like '김%아'
;


