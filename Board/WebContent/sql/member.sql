DROP TABLE member;

CREATE TABLE member (
    userid VARCHAR2(100) PRIMARY KEY,
    userpw VARCHAR2(100),
    usernick VARCHAR2(100)
);

INSERT INTO member( userid, userpw, usernick ) VALUES ('a', 'b', 'c');
INSERT INTO member( userid, userpw, usernick ) VALUES ('writer1', 'writer11', 'writer111');
INSERT INTO member( userid, userpw, usernick ) VALUES ('writer2', 'writer22', 'writer222');
INSERT INTO member( userid, userpw, usernick ) VALUES ('writer3', 'writer33', 'writer333');

commit;

SELECT * FROM member;
