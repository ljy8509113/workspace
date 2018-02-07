insert into users(email, password, name) values('apple@koitt.com', '1234', '사과' );
select * from users order by no desc ;

insert into board(title, content, user_no, regdate) values('사과-1', 'body-apple', 9, curdate());

select * from board order by no desc;
select b.no, b.title, b.content, u.email, b.regdate from board b, users u where b.user_no = u.no;

select b.no, b.title, b.content, b.regdate, u.email, u.name from board b, users u  where b.user_no = u.no order by b.no desc