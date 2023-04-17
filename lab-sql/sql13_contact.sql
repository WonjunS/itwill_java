-- 연락처(Contact) 테이블 생성
-- JDBC: 자바 프로그램으로 연락처 테이블을 관리
-- CRUD(Create, Read, Update, Delete)

create table contacts(
    cid     number(6)
            constraint contacts_cid_pk primary key,
    name    varchar2(100)
            constraint contacts_name_nn not null,
    phone   varchar2(100)
            constraint contacts_phone_nn not null,
    email   varchar2(100)
);

-- 연락처 저장
insert into contacts(name, phone, email)
values('관리자', '010-0000-0000', 'admin@email.com');

commit;

-- 연락처 전체 보기
select * from contacts order by cid;

-- PK로 검색하기
select * from contacts where cid = 1;

-- cid가 일치하는 연락처 수정하기
update contacts 
set phone = '010-1111-2222', email = 'abc@email.com'
where cid = 1;

-- cid가 일치하는 연락처 삭제하기
delete from contacts where cid = 1;

-- 검색 기능
select * from contacts 
where lower(name) like lower('%abc%')
    or lower(phone) like lower('%abc%')
    or lower(email) like lower('%abc%')
order by cid;
