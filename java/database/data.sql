BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;

BEGIN TRANSACTION;
-- Users
INSERT INTO users (username, password_hash, role)
VALUES ('brianr', 'techelevator1', 'ROLE_USER'),
('aartik', 'techelevator1', 'ROLE_USER'),
('yoavm', 'techelevator1', 'ROLE_USER'),
('beckyz', 'techelevator1', 'ROLE_USER'),
('brodinm', 'techelevator1', 'ROLE_USER'),
('andyk', 'techelevator1', 'ROLE_USER');

-- Posts
INSERT INTO posts (user_id, date_time, caption)
VALUES (3, '2023-01-01 18:03:20', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
(4, '2023-05-11 10:06:10', 'Vulputate dignissim suspendisse in est ante in nibh mauris. Maecenas sed enim ut sem viverra aliquet.'),
(5, '2023-03-21', 'Risus feugiat in ante metus dictum at tempor commodo ullamcorper.'),
(6, '2023-02-15 05:15:19', 'At risus viverra adipiscing at in tellus.'),
(7, '2023-06-19 17:03:01', 'Pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus.'),
(8, '2023-01-10 13:15:02', 'Duis convallis convallis tellus id interdum. Neque volutpat ac tincidunt vitae semper quis lectus nulla.');

