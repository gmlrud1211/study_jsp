DROP TABLE FILETB;
DROP TABLE COMMENTTB;
DROP TABLE BOARD;
DROP TABLE BOARD_CATE;
DROP TABLE USERTB;
DROP TABLE REPORT;
DROP TABLE GRADE;

CREATE TABLE board (
	boardno NUMBER primary key, -- �۹�ȣ
	title VARCHAR2(500), -- ����
	writer VARCHAR2(100), -- �ۼ��� ���̵�
	content VARCHAR2(4000), -- ����
	hit NUMBER, -- ��ȸ��
	writtendate DATE DEFAULT sysdate -- �����ۼ���
);

DROP SEQUENCE board_seq;
CREATE SEQUENCE board_seq;

SELECT * FROM board;
