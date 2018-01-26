CREATE TABLE BOARD(
		NO 			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
		TITLE 		VARCHAR(30) NOT NULL,
		CONTENT 	VARCHAR(255)	NULL ,
		WRITER   	VARCHAR(10)	NOT NULL,
		REGDATE 	DATE	NOT NULL,
		MODIDATE DATE 
);

insert into BOARD (title, content, writer, regdate, modidate) values('제목 - 1','내용 1','A', STR_TO_DATE('26-01-2018','%d-%m-%Y'), null);
insert into BOARD (title, content, writer, regdate, modidate) values('제목 - 2','내용 2','A', STR_TO_DATE('26-01-2018','%d-%m-%Y'), null);
insert into BOARD (title, content, writer, regdate, modidate) values('제목 - 3','내용 3','A', STR_TO_DATE('26-01-2018','%d-%m-%Y'), null);

insert into BOARD(title, content, writer, regdate, modidate) values('제목4','내용4','B',CURDATE(), null);

update BOARD set title = 'title-', content='contents', modidate=CURDATE() where NO=3;

select * from BOARD;