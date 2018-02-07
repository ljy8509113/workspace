CREATE TABLE book (
  isbn int NOT NULL AUTO_INCREMENT,
  title VARCHAR(50) NOT NULL,
  author varchar(20) not null,
  publicsher varchar(20) null,
  price int,
  description varchar(200) null, 
  PRIMARY KEY (isbn)
);

insert into book (title, author, publicsher, price, description) values ('����1','���۰�','ȸ��1',15000,'������ �����Ѵ�.');
insert into book (title, author, publicsher, price, description) values ('����2','�۰�1','ȸ��2',25000,'����̴�.');
insert into book (title, author, publicsher, price, description) values ('����3','�۰�2','ȸ��3',5000,'good book');
insert into book (title, author, publicsher, price, description) values ('����4','�۰�3','ȸ��4',9000,'����.');

