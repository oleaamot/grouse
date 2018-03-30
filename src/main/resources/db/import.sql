

INSERT INTO user (username, password, firstname, lastname) VALUES (
  'admin@kdrs.no',
  '{bcrypt}$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
  'John',
  'Smith');
/*
INSERT INTO projects (project_id, file_name, project_name, project_number,
                      username)
VALUES (1, 'kravspec', 'Eksempel kommune kravspec', '1', 'admin@kdrs.no');
*/


INSERT INTO role (role) VALUES ('ROLE_ADMIN');
INSERT INTO role (role) VALUES ('ROLE_USER');

INSERT INTO user_role (username, role) VALUES ('admin@kdrs.no', 'ROLE_ADMIN');
INSERT INTO user_role (username, role) VALUES ('admin@kdrs.no', 'ROLE_USER');
