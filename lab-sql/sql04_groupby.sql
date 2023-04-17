/* 오라클 함수(function)
     1. 단일 행 함수:
        행(row)이 하나씩 함수의 argument로 전달되고, 행 마다 하나씩 결과가 리턴되는 함수
     2. 다중 행 함수: 
        여러 개의 행이 함수의 argument로 전달되고, 하나의 결과가 리턴되는 함수
        (예) 통계 관련 예: count, sum, avg, max, min, variance(분산), stddev(표준편차), ...
     (주의) 단일 행 함수와 그룹 함수는 동시에 select에서 사용할 수 없음
*/

-- 단일 행 함수의 예 - 문자열을 소문자로 바꾸기
select ename, lower(ename)
from emp;

-- to_char(): 날짜 타입 데이터를 원하는 문자열 포맷으로 출력
select hiredate, to_char(hiredate, 'yyyy-mm-dd')
from emp;

-- nvl(컬럼, val): 컬럼이 null이면 val을 리턴하고, null이 아니면 원래 값을 리턴
-- nvl2(컬럼, val1, val2): 컬럼이 null이 아니면 val1을 리턴하고, null이면 val2를 리턴
select comm, nvl(comm, -1), nvl2(comm, comm, -1)
from emp;

-- 다중행 함수
-- count(컬럼): null이 아닌 행의 개수를 리턴
select count(empno), count(mgr)
from emp;

-- 테이블의 행(row)의 개수를 리턴
select count(*)
from emp;

-- 통계 함수: 합계, 평균, 최댓값, 최솟값, 분산, 표준편차
select sum(sal), avg(sal), max(sal), min(sal), variance(sal), stddev(sal)
from emp;

-- select sal, sum(sal) from emp;
-- 단일 행 함수와 다중 행 함수는 함께 사용할 수 없음

-- 그룹 별 쿼리
-- select ... from ... [where ...] group by ... [having ...] order by ...;
-- 부서별 급여 평균
select deptno, round(avg(sal), 2)
from emp
group by deptno
order by deptno;

-- 모든 문제에서 소수점은 반올림해서 소수점이하 2자리까지만 표시하세요.
-- Ex1. 부서별 급여 평균, 표준편차를 부서번호 오름차순으로 출력
select deptno, round(avg(sal), 2) "급여평균", round(stddev(sal), 2) "표준편차"
from emp
group by deptno
order by 1;

-- Ex2. 직무별 직무, 직원수, 급여 최댓값, 최솟값, 평균을 직무 오름차순으로 출력
select job, count(*) "직원수", max(sal) "급여최댓값", min(sal) "급여최솟값", round(avg(sal), 2) "급여평균"
from emp
group by job
order by job;

-- Ex3. 부서별, 직무별 부서번호, 직무, 직원수, 급여 평균을 검색
--      정렬 순서: (1) 부서번호, (2) 직무
select deptno, job, count(*) "직원수", round(avg(sal), 2) "급여평균"
from emp
group by deptno, job
order by 1, 2;

-- Ex4. 입사연도별 사원수를 검색
select to_char(hiredate, 'yyyy') as "입사연도", count(*) "사원수"
from emp
group by to_char(hiredate, 'yyyy')
order by 1;

/* select 문장 순서:
   select 컬럼, ...                           [5]
   from 테이블                                [1]
   where (그룹을 묶기 전에 검사할) 조건식        [2]
   group by 그룹으로 묶어줄 컬럼, ...           [3]
   having (그룹을 묶은 다음에 검사할) 조건식     [4]
   order by 출력 순서를 결정하기 위한 컬럼, ...; [6]
*/

-- 부서별 급여 평균 검색, 부서별 급여 평균이 2000 이상인 부서만 검색
select deptno, round(avg(sal), 2)
from emp
group by deptno
having avg(sal) >= 2000
order by 1;

-- mgr 컬럼이 null이 아닌 직원들 중에서 부서별 급여 평균을 검색 부서번호 오름차순
select deptno, avg(sal)
from emp
where mgr is not null
group by deptno
order by 1;

-- 직무별 사원수를 검색. PRESIDENT는 검색에서 제외. 직무별 사원수가 3명 이상인 직무만 검색.
-- 직무의 오름차순 정렬
select job, count(*)
from emp
where job not in 'PRESIDENT'
group by job
having count(*) >= 3
order by job;

-- 입사연도, 부서별, 입사연도별 부서별 사원수 검색
-- 1980년은 검색에서 제외
-- 연도별 부서별 사원수가 2명 이상인 경우만 선택
-- 연도별, 부서별 오름차순
select to_char(hiredate, 'yyyy'), deptno, count(*)
from emp
where to_char(hiredate, 'yyyy') != 1980
group by to_char(hiredate, 'yyyy'), deptno
having count(*) >= 2
order by 1, 2;