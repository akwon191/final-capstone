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
INSERT INTO posts (user_id, date_time, caption, image_data_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), '2023-01-01 18:03:20', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1),
((SELECT user_id FROM users WHERE username = 'aartik'), '2023-05-11 10:06:10', 'Vulputate dignissim suspendisse in est ante in nibh mauris. Maecenas sed enim ut sem viverra aliquet.', 2),
((SELECT user_id FROM users WHERE username = 'yoavm'), '2023-03-21', 'Risus feugiat in ante metus dictum at tempor commodo ullamcorper.', 3),
((SELECT user_id FROM users WHERE username = 'beckyz'), '2023-02-15 05:15:19', 'At risus viverra adipiscing at in tellus.', 4),
((SELECT user_id FROM users WHERE username = 'brodinm'), '2023-06-19 17:03:01', 'Pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus.', 5),
((SELECT user_id FROM users WHERE username = 'andyk'), '2023-01-10 13:15:02', 'Duis convallis convallis tellus id interdum. Neque volutpat ac tincidunt vitae semper quis lectus nulla.', 6);

-- Post_Comments
INSERT INTO post_comments (post_id, user_id, date_time, comment_text)
VALUES ((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'), (SELECT user_id FROM users WHERE username = 'aartik'),'2023-01-01 23:59:59', 'Nice!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik'), (SELECT user_id FROM users WHERE username = 'yoavm'),'2023-12-31 23:59:59', 'Great!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'yoavm'), (SELECT user_id FROM users WHERE username = 'beckyz'),'2023-12-31 23:59:59', 'Awesome!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'beckyz'), (SELECT user_id FROM users WHERE username = 'brodinm'),'2023-12-31 23:59:59', 'Beautiful!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brodinm'), (SELECT user_id FROM users WHERE username = 'andyk'),'2023-12-31 23:59:59', 'Cool!'),
((SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'andyk'), (SELECT user_id FROM users WHERE username = 'brianr'),'2023-12-31 23:59:59', 'How fun!');

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

-- Vibes
INSERT INTO vibes (user_id, post_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik')),
((SELECT user_id FROM users WHERE username = 'aartik'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'yoavm')),
((SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'beckyz')),
((SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brodinm')),
((SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'andyk')),
((SELECT user_id FROM users WHERE username = 'andyk'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'));

--Thanks
INSERT INTO thanks (user_id, post_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik')),
((SELECT user_id FROM users WHERE username = 'aartik'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'yoavm')),
((SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'beckyz')),
((SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brodinm')),
((SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'andyk')),
((SELECT user_id FROM users WHERE username = 'andyk'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr'));

--No_Thanks
INSERT INTO no_thanks (user_id, post_id)
VALUES ((SELECT user_id FROM users WHERE username = 'brianr'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'yoavm')),
((SELECT user_id FROM users WHERE username = 'aartik'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'beckyz')),
((SELECT user_id FROM users WHERE username = 'yoavm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brodinm')),
((SELECT user_id FROM users WHERE username = 'beckyz'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'andyk')),
((SELECT user_id FROM users WHERE username = 'brodinm'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'brianr')),
((SELECT user_id FROM users WHERE username = 'andyk'), (SELECT post_id FROM posts JOIN users ON posts.user_id = users.user_id WHERE username = 'aartik'));



COMMIT TRANSACTION;


