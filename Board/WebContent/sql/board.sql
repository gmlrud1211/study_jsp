DROP TABLE FILETB;
DROP TABLE COMMENTTB;
DROP TABLE BOARD;
DROP TABLE BOARD_CATE;
DROP TABLE USERTB;
DROP TABLE REPORT;
DROP TABLE GRADE;

CREATE TABLE board (
	boardno NUMBER primary key, -- 글번호
	title VARCHAR2(500), -- 제목
	writer VARCHAR2(100), -- 작성자 아이디
	content VARCHAR2(4000), -- 본문
	hit NUMBER, -- 조회수
	writtendate DATE DEFAULT sysdate -- 최초작성일
);

DROP SEQUENCE board_seq;
CREATE SEQUENCE board_seq;

SELECT * FROM board;
