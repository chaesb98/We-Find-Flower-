1. 컴파일 실행 환경 = JAVA SDK 1.6, ORACLE 11g, TOMCAT 9.0 , STS

2. 적용 기술 = Spring MVC, Mybatis, JAVA, JSP, HTML, CSS, BootStrap, Jquery(AJAX, JSON) , OracleDB

============================================================================================

3 STS - File - import - Existing Projects into Workspace - Stationery 및 Servers 임포트해줌.

=> 임포트 후 
	1) properties - Deployment Assembly -> ojdbc6.jar 추가(add)
	2) Java Build Path -> ojdbc6.jar
			   아파치 톰캣 v9.0
			   JRE System Library[jdk1.8.0_221]
			   JUnit 4
			   Maven Dependencies
			   Web App Libraries 있는 지 확인 후 추가
	3) Web Project Settings controller를 /로 변경

=> 아파치톰캣 서버 설정
Servers - Tomcat v9.0... 더블 클릭,  Module 클릭, 우측 "Edit.." 버튼 클릭! - Path:를 / 로 변경 후 OK 버튼 클릭 후 저장

============================================================================================

4 Oracle11g에 권한 부여 : sqlplus SYSTEM/System1234 접속 후 다음의 admin (비밀번호 : admin) 계정을 생성해줌. 

-- admin 계정이 있을 경우
drop user admin cascade;

--admin계정생성   
create user admin IDENTIFIED by admin
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE TEMP;

-- admin 계정 권한부여
GRANT CONNECT, DBA, RESOURCE TO admin;

--admin계정 접속 
conn admin/admin;

-- 계정 확인
show user;

-- WFFLAB_board 테이블 생성
CREATE TABLE WFFLAB_board (
	bno number(10, 0)	NOT NULL,
	id varchar2(20)	NOT NULL,
	title varchar2(200)	NOT NULL,
	content varchar2(2000)	NOT NULL,
	writer varchar2(50)	NOT NULL,
	replycnt number(10),
	regdate date default sysdate,
	updatedate date default sysdate
);
-- Member 테이블 생성
CREATE TABLE Member (
	id varchar2(20)	NOT NULL,
	password varchar2(40)	NOT NULL,
	email varchar2(80)	NOT NULL,
	name varchar2(20)	NOT NULL,
            address1 varchar2(100) NOT NULL,
	address2 varchar2(100) NOT NULL,
	address3 varchar2(100) NOT NULL
);
-- WFFLAB_reply 테이블 생성
CREATE TABLE WFFLAB_reply (
	rno number(10,0)	NULL,
	bno number(10, 0)	NOT NULL,
	reply varchar2(1000)	NOT NULL,
	replyer varchar2(50)	NOT NULL,
	replyDate date default sysdate, 
 	updateDate date default sysdate
);
-- Faq_Category 테이블 생성
CREATE TABLE Faq_Category (
	category  varchar2(50)	NOT NULL,
	categoryname varchar2(200)	NOT NULL
);
-- Inquiry 테이블 생성
CREATE TABLE Inquiry (
	inquirybno number(10,0)	NULL,
	id varchar2(20)	NOT NULL,
	incategory varchar2(50) 	NOT NULL,
	writer varchar2(50)	NOT NULL,
	title varchar2(200)	NOT NULL,
	content varchar2(2000)	NOT NULL,
	replyDate date default sysdate, 
  	updateDate date default sysdate
);
-- Inquiry_reply 테이블 생성
CREATE TABLE Inquiry_reply (
	rno number(10,0)	NULL,
	inquirybno number(10,0)	NULL,
	reply varchar2(1000)	NOT NULL,
	replyer varchar2(50)	NOT NULL,
	replyDate date default sysdate, 
 	updateDate date default sysdate
);
-- Notice 테이블 생성
CREATE TABLE Notice (
	noticebno number(10, 0)	NULL,
	admin varchar2(50)	NOT NULL,
	title varchar2(200)	NOT NULL,
	content varchar2(2000)	NOT NULL,
	regdate date default sysdate
);
-- inquiry_Category 테이블 생성
CREATE TABLE inquiry_Category (
	incategory  varchar2(50)	NOT NULL,
	categoryname varchar2(200)	NOT NULL
);
-- FAQ 테이블 생성
CREATE TABLE FAQ (
	bno number(10,0)	NOT NULL,
	category varchar2(50)	NOT NULL,
	writer varchar2(50)	NOT NULL,
	title varchar2(200)	NOT NULL,
	content varchar2(2000)	NOT NULL,
	regdate date default sysdate
);
-- 시퀀스 생성
create sequence WFFLAB_board_seq
increment by 1
start with 0
maxvalue 9999999
minvalue 0;
-- 기본키
ALTER TABLE WFFLAB_board ADD CONSTRAINT PK_WFFLAB_BOARD PRIMARY KEY (
	bno
);
-- 기본키 설정
ALTER TABLE Member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
	id
);
-- 기본키
ALTER TABLE WFFLAB_reply ADD CONSTRAINT PK_WFFLAB_REPLY PRIMARY KEY (
	rno
);
-- primary key
ALTER TABLE Faq_Category ADD CONSTRAINT PK_CATEGORY PRIMARY KEY (
	category
);
-- Inquiry 기본키
ALTER TABLE Inquiry ADD CONSTRAINT PK_INQUIRY PRIMARY KEY (
	Inquirybno
);

-- 기본키
ALTER TABLE NOTICE ADD CONSTRAINT PK_NOTICE PRIMARY KEY (
	noticebno
);
-- primary key
ALTER TABLE Inquiry_reply ADD CONSTRAINT PK_INQUIRY_REPLY PRIMARY KEY (
	rno
);
-- inquiry_Category 기본키
ALTER TABLE inquiry_Category ADD CONSTRAINT PK_INQUIRY_Category PRIMARY KEY (
	inCategory
);
-- primary key
ALTER TABLE FAQ ADD CONSTRAINT PK_FAQ PRIMARY KEY (
	bno
);
--외래키
ALTER TABLE WFFLAB_board ADD CONSTRAINT FK_Member_TO_WFFLAB_board FOREIGN KEY (
	id
)
REFERENCES Member (
	id
);
-- 외래키
alter table WFFLAB_reply  add constraint FK_WFFLAB_board  
foreign key (bno)  references  WFFLAB_board (bno); 
-- WFFLAB_reply_seq 시퀀스 생성
create sequence WFFLAB_reply_seq
increment by 1
start with 0
maxvalue 9999999
minvalue 0;
-- Inquiry_seq 시퀀스 생성
create sequence Inquiry_seq
increment by 1
start with 0
maxvalue 9999999
minvalue 0;
-- Inquiry_reply_seq 시퀀스 생성
create sequence Inquiry_reply_seq
increment by 1
start with 0
maxvalue 9999999
minvalue 0;
-- Notice_seq 시퀀스 생성
create sequence Notice_seq
increment by 1
start with 0
maxvalue 9999999
minvalue 0;
-- FAQ_seq 시퀀스 생성
create sequence FAQ_seq
increment by 1
start with 0
maxvalue 9999999
minvalue 0;
--Reference key
alter table FAQ add constraint FK_FAQ_category
foreign key (category)  references  FAQ_category (category);
-- Inquiry Reference key
ALTER TABLE Inquiry ADD CONSTRAINT FK_Member_TO_Inquiry FOREIGN KEY (
	id
)
REFERENCES Member (
	id
);
ALTER TABLE Inquiry ADD CONSTRAINT FK_inquiryCategory_TO_Inquiry FOREIGN KEY (
	incategory
)
REFERENCES inquiry_Category (
	incategory
);
-- Inquiry_reply Reference key
ALTER TABLE Inquiry_reply ADD CONSTRAINT FK_Inquiry_TO_Inquiry_reply FOREIGN KEY (
	inquirybno
)
REFERENCES Inquiry (
	Inquirybno
);
-- 기존에 있던 제약조건 제거하기
-- alter table (자식)테이블이름
-- drop constraint 제약조건이름
alter table wfflab_board
drop constraint FK_MEMBER_TO_WFFLAB_BOARD;
-- 제약조건 cacade 추가하여 생성
alter table wfflab_board
add constraint wfflab_board_child
foreign key (ID)
references  member(id)
on delete cascade;


--제약조건 해제
alter table wfflab_reply
drop constraint FK_WFFLAB_BOARD;
-- 제약조건 cacade 추가하여 생성
alter table wfflab_reply add constraint 
fk_wfflab_board_bno foreign key (BNO)
references  WFFLAB_board (BNO)
on delete cascade;

commit;

============================================================================================
6. WFF(We Find Flower!) 프로그램 기능 설명

[웹프로젝트_로그인_회원가입_공지사항]Spring MVC(OracleDB), MyBatis, JAVA, JSP, HTML, CSS, BOOTSTRAP, Jquery(Ajax,JSON)

* 기능 : (Member) 회원가입/ 로그인/ 회원정보 수정/ 회원탈퇴/ 아이디, 비밀번호 찾기
          (wfflabboard) 게시판 게시물 리스트 및 페이징/ 게시물 조회/ 게시물 등록, 수정, 삭제/ 댓글 등록 및 댓글 수 표현 

* 게시판 글 등록할 시 로그인을 해야 등록이 됨 ( 로그인을 하지 않으면 오류창이 뜸 )

* 비밀번호 찾기 후 리다이렉트 되는데 다시 비밀번호 찾기 버튼을 눌러야함

* member에 있는 기능은 login을 해야 가능

7. css, js 파일 경로 => src.main.webapp.resources 

8. 주요기술 

   1) Spring MVC(OracleDB 연동)

   2) 비동기 JSON  처리