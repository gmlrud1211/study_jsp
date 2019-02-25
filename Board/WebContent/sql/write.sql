DROP TABLE boardFile;
CREATE TABLE boardFile (
    fileno NUMBER PRIMARY KEY,
    boardno NUMBER,
    originname VARCHAR2(300),
    storedname VARCHAR2(300),
    filesize NUMBER,
    writeDate DATE DEFAULT sysdate
);

ALTER TABLE boardfile
ADD CONSTRAINT boardfile_fk
    FOREIGN KEY (boardno)
    REFERENCES board(boardno);

DROP SEQUENCE boardfile_seq;
CREATE SEQUENCE boardFile_seq;

select * from boardFile;