INSERT INTO ROLE (ID, NAME) values (10, 'SuperUser'), (11, 'Regular User'), (12, 'Admin User');
INSERT INTO USER (ID, NAME, EMAIL) values (10, 'Ben Dover', 'ben@dover.com'), (11, 'Dixie Normous', 'dix@biggly.com'), (12, 'Don Boobly', 'thedman@boobly.com'), (13, 'Razman Viking', 'vvv@zzzz.com');
INSERT INTO USER_ROLES (USER_ID, ROLE_ID) values (10, 11), (10, 12), (11, 10);
INSERT INTO PERMISSION (ID, NAME) values (10, 'view:user'), (11, 'edit:user'), (12, 'delete:user')
INSERT INTO ROLE_PERMISSIONS(ROLE_ID, PERMISSION_ID) values (10, 10), (10, 11), (10, 12), (11, 10), (12, 10), (12, 11);