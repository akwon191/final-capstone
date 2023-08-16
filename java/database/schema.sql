BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, posts, post_comments, images, image_data, user_following, thanks, no_thanks, vibes, profiles;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE posts (
        post_id serial NOT NULL,
        user_id int NOT NULL,
        date_time TIMESTAMP NOT NULL,
        caption varchar (150) NOT NULL,
        CONSTRAINT PK_post PRIMARY KEY (post_id),
        CONSTRAINT FK_user_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE post_comments (
        comment_id serial NOT NULL,
        user_id int NOT NULL,
        post_id int NOT NULL,
        username varchar(50) NOT NULL,
        date_time TIMESTAMP NOT NULL,
        comment_text varchar (150),
        CONSTRAINT PK_comment PRIMARY KEY (comment_id),
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
        CONSTRAINT FK_post_id FOREIGN KEY (post_id) REFERENCES posts (post_id),
        CONSTRAINT FK_username FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE image_data(
	image_data_id serial PRIMARY KEY,
	image_name varchar(500) NOT NULL,
	image_data bytea NOT NULL
);

CREATE TABLE images (
        image_id serial NOT NULL,
		image_data_id int NOT NULL,
        post_id int NOT NULL,
--         image_url varchar (200) NOT NULL,
        CONSTRAINT PK_image PRIMARY KEY (image_id),
		CONSTRAINT FK_image_data_id FOREIGN KEY (image_data_id) REFERENCES image_data (image_data_id),
        CONSTRAINT FK_image_post_id FOREIGN KEY (post_id) REFERENCES posts (post_id)
);



CREATE TABLE user_following (
        user_id int NOT NULL,
        follower_id int NOT NULL,
        CONSTRAINT FK_follower FOREIGN KEY (user_id) REFERENCES users (user_id),
        CONSTRAINT FK_following FOREIGN KEY (follower_id) REFERENCES users (user_id)
);

CREATE TABLE vibes (
        user_id int NOT NULL,
        post_id int NOT NULL,
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
        CONSTRAINT FK_post_id FOREIGN KEY (post_id) REFERENCES posts (post_id)
);

CREATE TABLE thanks (
        user_id int NOT NULL,
        post_id int NOT NULL,
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
        CONSTRAINT FK_post_id FOREIGN KEY (post_id) REFERENCES posts (post_id)
);

CREATE TABLE no_thanks (
        user_id int NOT NULL,
        post_id int NOT NULL,
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
        CONSTRAINT FK_post_id FOREIGN KEY (post_id) REFERENCES posts (post_id)
);

CREATE TABLE profiles (
        user_id int NOT NULL,
        username int NOT NULL,
        description varchar (350) NOT NULL,
        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
        CONSTRAINT FK_username FOREIGN KEY (username) REFERENCES users (user_id)
);

COMMIT TRANSACTION;

START TRANSACTION;

DROP TABLE images;

ALTER TABLE posts
ADD COLUMN image_data_id INT,
ADD CONSTRAINT FK_image_data_id FOREIGN KEY (image_data_id) REFERENCES image_data (image_data_id);

COMMIT;
