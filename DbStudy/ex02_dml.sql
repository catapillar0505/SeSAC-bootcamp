# insert

USE member_db;
select * from members;

INSERT INTO members ( mem_id, mem_name, mem_number, addr, phone1, phone2, height, debut_date)
VALUES 
( '44444444', '나연', 1, 'KR', '010', '44445555', 163, NOW()),
( '55555555', '쯔위', 1, 'TW', '010', '44445555', 175, NOW()),
( '66666666', '다현', 2, 'KR', '010', '24342343', 156, NOW()),
( '77777777', '지효', 3, 'KR', '010', '23214444', 162, NOW());

INSERT INTO visit_history(mem_id, visited_at) VALUES ('12345678',Now());
INSERT INTO visit_history(mem_id, visited_at) VALUES ('00000000',Now());
INSERT INTO visit_history(mem_id, visited_at) VALUES ('11111111',Now());

INSERT INTO visit_history(mem_id, visited_at) VALUES ('11111111',Now());

-- UPDATE

UPDATE members
   SET mem_name = '김철수'
 WHERE mem_id='12345678'; -- 조건은 pk를 사용할 것

-- DELETE

DELETE FROM members
WHERE mem_id = '12345678';



