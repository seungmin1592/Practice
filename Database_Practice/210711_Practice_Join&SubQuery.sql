-- 2021.06.20

-- SQL 문제풀이
-- 복습 및 다시 풀어보기

-- JOIN & SUB QUERY


-- 1. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

-- (5) 박지성이 구매한 도서의 출판사 수

select *
from orders o, book b
where o.custid = (select custid from customer where name = '박지성')
;


select * from book;
select * from orders;
select * from customer;
