CREATE TABLE book (
  isbn int NOT NULL AUTO_INCREMENT,
  title VARCHAR(50) NOT NULL,
  author varchar(20) not null,
  publicsher varchar(20) null,
  price int,
  description varchar(200) null, 
  PRIMARY KEY (isbn)
);

insert into book (title, author, publicsher, price, description) values ('제목1','나작가','회사1',15000,'설명은 생략한다.');
insert into book (title, author, publicsher, price, description) values ('제목2','작가1','회사2',25000,'비밀이다.');
insert into book (title, author, publicsher, price, description) values ('제목3','작가2','회사3',5000,'good book');
insert into book (title, author, publicsher, price, description) values ('제목4','작가3','회사4',9000,'몰라.');

