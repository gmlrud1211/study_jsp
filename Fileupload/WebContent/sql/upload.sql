create table upload (
    fileno number primary key,
    originName varchar2(500),
    storedName varchar2(500),
    uploadDate Date);
create sequence seq_upload;

insert into upload(fileno, originName, storedName, uploadDate)
values (seq_upload.nextval, 'A','A123456', sysdate);

select * from upload;