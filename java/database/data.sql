BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;

BEGIN TRANSACTION;
-- Users
INSERT INTO users (username, password_hash, role)
VALUES ('brianr', '$2a$10$xr4oT4kYUK7JKNCyvUV/.OrhzCv/AyNTkXHHB6nuxE0Rvten95Oeq', 'ROLE_USER'),
('aartik', '$2a$10$OwQsPAN8f/MPxcPq1D9kPeVz9SvKb4BR7yzPJUCVybC1.yyHqP4jG', 'ROLE_USER'),
('yoavm', '$2a$10$8zTJoG.b5jLoymTnNyiQcuAvtPZ/fLL4CWTLRs6rU3RyiPE8NcTlO', 'ROLE_USER'),
('beckyz', '$2a$10$9HDhkJ0u3FkGwgJXXvES4.5crkYp9ouFpDMDA/n7cgxM/F.7InSHi', 'ROLE_USER'),
('brodinm', '$2a$10$zyB7UwoRSBDfEd1NvDI8HO1.KJRfN1eO3xDeQvKBVpI5P9Uq7pgw.', 'ROLE_USER'),
('andyk', '$2a$10$0MhExxOdGod7mK/DomEqGul1YteHnXQWvseA/MfYQxN3RYUP175t6', 'ROLE_USER');

COMMIT TRANSACTION;

BEGIN TRANSACTION;

-- Posts
INSERT INTO posts (user_id, date_time, caption, image_data_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), '2023-01-01 18:03:20', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1),
((SELECT user_id FROM users WHERE username = 'aartik'), '2023-05-11 10:06:10', 'Vulputate dignissim suspendisse in est ante in nibh mauris. Maecenas sed enim ut sem viverra aliquet.', 2),
((SELECT user_id FROM users WHERE username = 'yoavm'), '2023-03-21', 'Risus feugiat in ante metus dictum at tempor commodo ullamcorper.', 3),
((SELECT user_id FROM users WHERE username = 'beckyz'), '2023-02-15 05:15:19', 'At risus viverra adipiscing at in tellus.', 4),
((SELECT user_id FROM users WHERE username = 'brodinm'), '2023-06-19 17:03:01', 'Pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus.', 5),
((SELECT user_id FROM users WHERE username = 'andyk'), '2023-01-10 13:15:02', 'Duis convallis convallis tellus id interdum. Neque volutpat ac tincidunt vitae semper quis lectus nulla.', 6);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

-- Post_Comments
INSERT INTO post_comments (post_id, user_id, username, date_time, comment_text)
VALUES ((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'), (SELECT user_id FROM users WHERE username = 'aartik'),(SELECT username FROM users WHERE username = 'aartik'),'2023-01-01 23:59:59', 'Nice!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik'), (SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT username FROM users WHERE username = 'yoavm'),'2023-12-31 23:59:59', 'Great!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'yoavm'), (SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT username FROM users WHERE username = 'beckyz'),'2023-12-31 23:59:59', 'Awesome!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'beckyz'), (SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT username FROM users WHERE username = 'brodinm'),'2023-12-31 23:59:59', 'Beautiful!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brodinm'), (SELECT user_id FROM users WHERE username = 'andyk'), (SELECT username FROM users WHERE username = 'andyk'),'2023-12-31 23:59:59', 'Cool!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'andyk'), (SELECT user_id FROM users WHERE username = 'brianr'), (SELECT username FROM users WHERE username = 'brianr'),'2023-12-31 23:59:59', 'How fun!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'), (SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT username FROM users WHERE username = 'beckyz'),'2023-02-01 23:59:59', 'Quis enim lobortis scelerisque fermentum dui faucibus in ornare quam.'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik'), (SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT username FROM users WHERE username = 'beckyz'),'2024-01-03 23:59:59', 'Commodo odio aenean sed adipiscing diam donec. '),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'), (SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT username FROM users WHERE username = 'brodinm'),'2023-01-10 23:59:59', 'Orci ac auctor augue mauris augue.'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik'), (SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT username FROM users WHERE username = 'brodinm'),'2024-01-05 23:59:59', 'Sed arcu non odio euismod lacinia at quis risus sed.'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'), (SELECT user_id FROM users WHERE username = 'andyk'), (SELECT username FROM users WHERE username = 'andyk'),'2023-01-06 23:59:59', 'Nibh venenatis cras sed felis eget velit aliquet sagittis id.'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik'), (SELECT user_id FROM users WHERE username = 'andyk'), (SELECT username FROM users WHERE username = 'andyk'),'2024-01-02 23:59:59', 'Elit ullamcorper dignissim cras tincidunt.');

COMMIT TRANSACTION;

BEGIN TRANSACTION;

--User_Following
INSERT INTO user_following (user_id, follower_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), (SELECT user_id FROM users WHERE username = 'aartik')),
((SELECT user_id FROM users WHERE username = 'brianr'), (SELECT user_id FROM users WHERE username = 'yoavm')),
((SELECT user_id FROM users WHERE username = 'aartik'), (SELECT user_id FROM users WHERE username = 'yoavm')),
((SELECT user_id FROM users WHERE username = 'aartik'), (SELECT user_id FROM users WHERE username = 'beckyz')),
((SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT user_id FROM users WHERE username = 'beckyz')),
((SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT user_id FROM users WHERE username = 'brodinm')),
((SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT user_id FROM users WHERE username = 'brodinm')),
((SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT user_id FROM users WHERE username = 'andyk')),
((SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT user_id FROM users WHERE username = 'andyk')),
((SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT user_id FROM users WHERE username = 'brianr')),
((SELECT user_id FROM users WHERE username = 'andyk'), (SELECT user_id FROM users WHERE username = 'brianr')),
((SELECT user_id FROM users WHERE username = 'andyk'), (SELECT user_id FROM users WHERE username = 'aartik'));

COMMIT TRANSACTION;

BEGIN TRANSACTION;

-- Vibes
INSERT INTO vibes (user_id, post_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik')),
((SELECT user_id FROM users WHERE username = 'aartik'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'yoavm')),
((SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'beckyz')),
((SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brodinm')),
((SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'andyk')),
((SELECT user_id FROM users WHERE username = 'andyk'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'));

COMMIT TRANSACTION;

BEGIN TRANSACTION;

--Thanks
INSERT INTO thanks (user_id, post_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik')),
((SELECT user_id FROM users WHERE username = 'aartik'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'yoavm')),
((SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'beckyz')),
((SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brodinm')),
((SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'andyk')),
((SELECT user_id FROM users WHERE username = 'andyk'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'));

COMMIT TRANSACTION;

BEGIN TRANSACTION;

--No_Thanks
INSERT INTO no_thanks (user_id, post_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'yoavm')),
((SELECT user_id FROM users WHERE username = 'aartik'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'beckyz')),
((SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brodinm')),
((SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'andyk')),
((SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr')),
((SELECT user_id FROM users WHERE username = 'andyk'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik'));

COMMIT TRANSACTION;







