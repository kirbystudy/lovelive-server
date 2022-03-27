INSERT INTO `user` (id, username, nickname, password, created_time, updated_time)
VALUES ('1', 'admin', '程序员小埋', '$2a$10$MC93xs8vFYCemn7KlIYm3eYMczCTvjanPV5FEwrrYds9gI00dFara',
        '2022-03-21 01:02:15.691000',
        '2022-03-21 01:02:15.691000');

INSERT INTO `role` (id, name, title, created_time, updated_time)
VALUES ('1', 'ROLE_USER', '普通用户', '2022-03-21 01:02:15.691000', '2022-03-21 01:02:15.691000');
INSERT INTO `role` (id, name, title, created_time, updated_time)
VALUES ('2', 'ROLE_ADMIN', '超级管理员', '2022-03-21 01:02:15.691000', '2022-03-21 01:02:15.691000');
INSERT INTO `user_role` (user_id, role_id)
VALUES ('1', '1');
INSERT INTO `user_role` (user_id, role_id)
VALUES ('1', '2');