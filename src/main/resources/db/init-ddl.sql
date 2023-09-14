/*
* Database init DDL script when using MySQL
*/
create table lecture(
    id bigint auto_increment primary key comment 'ID',
    speaker varchar(50) not null comment '강연자',
    place varchar(50) not null comment '강연장',
    number_applicant int not null comment '신청 가능 인원',
    contents varchar(255) not null comment '강연 내용',
    created_at datetime(6) not null comment '생성 일시',
    updated_at datetime(6) null comment '수정 일시'
) comment 'lecture' charset = utf8mb4;

create index lecture_idx01 on lecture (created_at);








