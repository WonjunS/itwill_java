-- 치킨 주문 분석:

-- 1. https://github.com/JakeOh/20230228_itwill_java140_lab_java/blob/master/lab-oracle/call_chicken.csv
-- 파일의 내용을 저장할 수 있는 테이블을 생성하는 SQL 문을 작성하세요.
create table call_chicken (
    call_date   date,
    call_day    varchar2(1 char),
    district    varchar2(4 char),
    age_band    varchar2(5 char),
    gender      varchar2(1 char),
    calls       number(4, 0)
);

-- 2. SQLDeveloper에서 '데이터 임포트' 기능을 사용해서 CSV 파일의 내용을 테이블에 저장하세요.

-- 3. 통화건수의 최솟값, 최댓값을 찾으세요.
select min(calls) as "통화건수의 최솟값", max(calls) as "통화건수의 최댓값"
from call_chicken;

-- 4. 통화건수가 최솟값이거나 최댓값인 레코드(행 전체)를 출력하세요.
select *
from call_chicken 
where calls = (select min(calls) from call_chicken)
or calls = (select max(calls) from call_chicken)
order by calls;

-- 5. 평균적으로 어떤 요일에서 치킨 주문이 많을까요?
select call_day, round(avg(calls), 2) as "평균 통화건수"
from call_chicken
group by call_day
order by 2 desc;

-- 6. 평균적으로 어떤 연령대가 치킨 주문을 많이 할까요?
select age_band, round(avg(calls), 2) as "하루 평균 통화건수"
from call_chicken
group by age_band
order by 2 desc;

-- 7. 평균적으로 어느 지역에서 치킨 주문을 많이 할까요?
select district, round(avg(calls), 2)
from call_chicken
group by district
order by 2 desc;

-- 8. 치킨 주문에 성별 차이가 있을까요?
select gender, avg(calls), round(sum(calls) / 28, 2) as "하루 평균 통화건수"
from call_chicken
group by gender
order by 2 desc;

-- 9. 요일별, 연령대별 통화건수의 평균을 찾으세요.
select call_day, age_band, round(sum(calls) / 4, 2) as "평균 통화건수"
from call_chicken
group by call_day, age_band
order by 1, 2;

-- 10. 구별, 성별 통화건수의 평균을 찾으세요.
select district, gender, round(avg(calls), 2) as "하루 평균 통화건수", sum(calls) / 6/ 28
from call_chicken
group by district, gender
order by 1, 2;

-- 11. 요일별, 구별, 연령대별 통화건수의 평균을 찾으세요.
select call_day, district, age_band, round(avg(calls), 2) as "평균 통화건수"
from call_chicken
group by call_day, district, age_band
order by 2, 3, 1;

-- 3 ~ 11 문제의 출력은 통화건수 평균의 내림차순 정렬, 소숫점 2자리까지 반올림.