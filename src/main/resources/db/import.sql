
INSERT INTO projects (project_id, file_name, project_name, project_number, project_owner)
VALUES (1, 'kravspec', 'Eksempel kommune kravspec', '1', 'Link to user table when it is in place');


INSERT INTO project_requirement (requirement_id, project_id) VALUES ('5.1.1', '1');
INSERT INTO project_requirement (requirement_id, project_id) VALUES ('5.1.2', '1');
INSERT INTO project_requirement (requirement_id, project_id) VALUES ('5.1.3', '1');
INSERT INTO project_requirement (requirement_id, project_id) VALUES ('5.1.4', '1');

INSERT INTO user (username, password, firstname, lastname) VALUES (
  'admin@krds.no',
  '{bcrypt}$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
  'John',
  'Smith');

INSERT INTO role (role) VALUES ('ROLE_ADMIN');
INSERT INTO role (role) VALUES ('ROLE_USER');

INSERT INTO user_role (username, role) VALUES ('admin@krds.no', 'ROLE_ADMIN');
INSERT INTO user_role (username, role) VALUES ('admin@krds.no', 'ROLE_USER');
