
-- DATA 정의

-- 사용자 초기 데이터
INSERT INTO users(email, nickname) VALUES
('user1@example.com', 'user1'),
('user2@example.com', 'user2'),
('user3@example.com', 'user3');

--  게시글 초기 데이터
INSERT INTO posts(user_id, title, content) VALUES
(1, '스프링 스터디 모집', '민나 오이데~'),
(1, 'MYBATIS 스터디 모집', '민나 오이데~!!!'),
(2, '점심 같이 먹어용', '마떼루용~');