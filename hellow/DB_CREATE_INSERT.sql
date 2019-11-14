--	нужно создать юзера bloger
--	create user bloger identified by "1234";
--	Grant connect, resource to bloger;

drop table posts CASCADE CONSTRAINTS;
create table posts
(
id NUMBER(20),
post_text   VARCHAR(1000) not null,
post_name   VARCHAR(45) not null,
post_creator VARCHAR(100) not null,
CONSTRAINT con_pk_post PRIMARY KEY(id)
);

drop table comments CASCADE CONSTRAINTS;
create table comments
(
id  NUMBER(20),
comment_text    VARCHAR(1000) not null,
comment_owner   VARCHAR(100)  not null,
post_id         NUMBER(20) not null,
CONSTRAINT con_pk_comment PRIMARY KEY(id),
CONSTRAINT con_fk_commnet FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE
);

drop sequence post_pk_seq;
Create sequence post_pk_seq 
	Increment by 1
	start with 1
	nomaxvalue
	nocache
	nocycle;

drop sequence comment_pk_seq;
Create sequence comment_pk_seq 
	Increment by 1
	start with 1
	nomaxvalue
	nocache
	nocycle;

insert into bloger.posts values(post_pk_seq.nextval,'text_post1','post_1','user1');
insert into bloger.posts values(post_pk_seq.nextval,'text_post2','post_2','user1');
insert into bloger.posts values(post_pk_seq.nextval,'text_post3','post_3','user2');
insert into bloger.posts values(post_pk_seq.nextval,'text_post4','post_4','user3');

insert into bloger.comments values(comment_pk_seq.nextval,'comment_text1','user4',1);
insert into bloger.comments values(comment_pk_seq.nextval,'comment_text2','user3',1);
insert into bloger.comments values(comment_pk_seq.nextval,'comment_text3','user1',3);
insert into bloger.comments values(comment_pk_seq.nextval,'comment_text4','user2',2);
insert into bloger.comments values(comment_pk_seq.nextval,'comment_text5','user3',2);
commit;
