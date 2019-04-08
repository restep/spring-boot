DROP TABLE IF EXISTS readlist;

CREATE TABLE readlist
(
  id           INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  reader       VARCHAR(20),
  isbn         VARCHAR(20),
  title        VARCHAR(20),
  author       VARCHAR(20),
  description  VARCHAR(20)
);

INSERT INTO readlist
(
  reader, isbn, title, author, description
)
VALUES
('reader01', "isbn01", "title01", "author01", "description01"),
('reader02', "isbn02", "title02", "author02", "description02"),
('reader03', "isbn03", "title03", "author03", "description03"),
('reader04', "isbn04", "title04", "author04", "description04")
