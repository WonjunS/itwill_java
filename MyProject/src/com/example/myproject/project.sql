create table member(
    member_id       number(6, 0)
                    constraint member_id_pk primary key,
    member_name     varchar2(20 char)
                    constraint member_name_nn not null,
    email           varchar2(50 char)
                    constraint member_email_nn not null,
    password        varchar2(20 char)
                    constraint member_pw_nn not null,
    nickname        varchar2(20 char)
                    constraint member_nickname_nn not null,
    created_time    timestamp,
    modified_time   timestamp
);

create table post(
    post_id         number(6, 0)
                    constraint post_id_pk primary key,
    title           varchar2(50 char)
                    constraint post_title_nn not null,
    content         varchar2(250 char)
                    constraint post_content_nn not null,
    writer          varchar2(20 char)
                    constraint post_writer_nn not null,
    views           number(6, 0),
    likes           number(6, 0),
    created_time    timestamp,
    modified_time   timestamp,
    member_id       number(6, 0)
                    constraint post_id_fk references member(member_id)
);