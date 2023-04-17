/*
SQL 종류:
1. DQL(Data Query Language): 데이터 질의 언어. select 문장
2. DML(Data Manipulation Language): 데이터 조작 언어
   - insert, update, delete
   - 테이블의 행(row)를 추가, 변경, 삭제하는 SQL 문장
3. DDL(Data Definition Language): 데이터 정의 언어
   - create, alter, truncate, drop
   - 테이블, 사용자 계정을 생성, 변경, 삭제하는 SQL 문장
4. TCL(Transaction Control, Language): 트랜잭션 관리(제어) 문장
   - commit: 데이터베이스의 변경 내용을 영구 저장
   - rollback: 직전의 commit 상태로 되돌리기
*/

/*
테이블 생성:
create table 테이블이름 (
    컬럼 이름 데이터타입 [제약조건 기본값],
    ...
);

데이터 타입의 이름(키워드)은 데이터베이스 종류에 따라서 다름
Oracle의 데이터 타입: number, varchar2, date, timestamp, clob, blob, ...
*/

/*
테이블 이름: students
컬럼:
    - stuNo: 학생 아이디. 학번. 숫자(6자리 정수)
    - stuName: 학생 이름. 문자열(10글자)
    - birthday: 학생 생일. 날짜
*/

create table students
(
stuNo    number(6),
stuName  varchar2(10 char),
birthday date
);

/*
테이블에 행(row) 추가(삽입):
insert into 테이블 (col1, col2, ...) values(val1, val2, ...);
insert into 테이블 values(val1, ...);
- values에서 나열하는 값의 개수는 테이블의 컬럼 수와 같아야 하고, 값의 순서는 컬럼의 순서와 같아야 함
*/

insert into students
values(1, '홍길동', '2023-04-11');

insert into students
values(2, '홍길동', null);

insert into students(stuno, stuname)
values(3, '홍길동');

insert into students(stuname, stuno, birthday)
values('홍길동', 4, to_date('2000/01/01'));

select * from students;

commit;

-- 테이블 생성할 때 컬럼의 기본값 설정하기:
create table ex_user(
    no            number(4),
    userid        varchar2(20),
    password      varchar2(100),
    age           number(3) default 0,
    created_date  date default sysdate
);

insert into ex_user(no, userid, password)
values(1, 'guest', 'guest0000');
--> default 값이 설정된 컬럼들은 insert하지 않으면 기본값이 insert됨

insert into ex_user(userid, password)
values('admin', 'admin0000');
--> default 값이 설정되지 않은 컬럼들은 insert하지 않으면 null됨

select * from ex_user;

commit;

-- 제약 조건: (1) primary key(고유키), (2) not null, (3) unique, (4) check, (5) foreign key(외래키)
create table ex1 (
    col1    number(2) primary key,      -- null이 아니고, 중복되지 않는 유일한 값 -> 유일한 행 1개를 검색
    col2    varchar2(100) not null,     -- 반드시 값이 insert되어야 함
    col3    varchar2(100) unique,       -- 중복되지 않은 유일한 값만 허용
    col4    number(2) check(col4 >= 0), -- 조건을 검사
    col5    number(2)
);

insert into ex1
values(1, '홍길동', 'test', 10, 0);

insert into ex1(col1, col2)
values(1, '홍길동');
--> PK 제약조건 위배: 중복되는 값이어서

insert into ex1(col2)
values('홍길동');
--> PK 제약조건 위배: PK는 null이 되면 안 됨

insert into ex1(col1, col2)
values(2, '김길동');

insert into ex1(col1)
values(3);
--> col2가 NN이라는 제약조건을 위배

insert into ex1(col1, col2, col3)
values(3, '홍길동', 'test');
--> col3가 중복된 값을 허용하지 않는다(unique)는 제약조건에 위배

insert into ex1(col1, col2, col4)
values(3, '홍길동', -10);
--> col4 >= 0 제약조건에 위배

select * from ex1;

