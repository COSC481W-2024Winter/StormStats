CREATE TABLE encounters (
username STRING NOT NULL,
gamenumber INT NOT NULL,
killsassists INT NOT NULL,
deaths INT NOT NULL,
siegedmg INT NOT NULL,
herodmg INT NOT NULL,
healing INT,
selfhealing INT,
expsoak INT NOT NULL,
sameteam BOOLEAN NOT NULL
);

CREATE TABLE playergames (
username STRING NOT NULL,
gamenumber INT NOT NULL,
userkillsassists INT NOT NULL,
userdeaths INT NOT NULL,
usersiegedmg INT NOT NULL,
userherodmg INT NOT NULL,
userhealing INT,
userselfhealing INT,
userexpsoak INT NOT NULL,
map STRING NOT NULL,
won BOOLEAN NOT NULL
);