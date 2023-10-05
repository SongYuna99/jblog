desc user;
desc blog;
desc category;
desc post;

-- user 
-- 테스트 유저 입력
SELECT * FROM user;
COMMIT;
INSERT INTO user(id, name, password)
values('test', '테스트', password('123'));
DELETE FROM user where id = 'aaa';

-- blog 
SELECT * FROM blog;
DELETE FROM blog where blog_id = 'aaa';

-- category 
SELECT * FROM category;
DELETE FROM category where blog_id = 'aaa';