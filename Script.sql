--<ScriptOptions statementTerminator=";"/>

CREATE TABLE checkusers (
		userid INT4 NOT NULL,
		checkaccount INT4 NOT NULL
	);

CREATE UNIQUE INDEX checkusers_pkey ON checkusers (userid ASC, checkaccount ASC);

ALTER TABLE checkusers ADD CONSTRAINT checkusers_pkey PRIMARY KEY (userid, checkaccount);

ALTER TABLE checkusers ADD CONSTRAINT fk_checkuser__user FOREIGN KEY (userid)
	REFERENCES users (id);

ALTER TABLE checkusers ADD CONSTRAINT fk_checkuser__checkid FOREIGN KEY (checkaccount)
	REFERENCES checks (id);

