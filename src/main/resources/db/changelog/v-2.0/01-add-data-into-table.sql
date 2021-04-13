insert into users (username, password) VALUES ('Admin', '$2y$12$HvdKSw90InZl885H4NYikOGHsNYhcwKPsgDJGOhUe69PrhB4zTfie'),
                                              ('Liz', '$2y$12$HvdKSw90InZl885H4NYikOGHsNYhcwKPsgDJGOhUe69PrhB4zTfie'),
                                              ('Nick', '$2y$12$HvdKSw90InZl885H4NYikOGHsNYhcwKPsgDJGOhUe69PrhB4zTfie')

GO

insert into tasks (taskname, priority, date_create, date_start)
            VALUES ('task1', 1, '2021-04-07', null),
                   ('task2', 1, '2021-04-07', null),
                   ('task3', 1, '2021-04-07', null)

GO

insert into roles (rolename) VALUES  ('ADMIN'), ('USER1'), ('USER2')

GO

insert into users_roles
select r.id, u.id from
                      (select id from roles where rolename = 'USER1') r,
                      (select id from users where username ='Liz') u

GO

insert into users_roles
select r.id, u.id from
                      (select id from roles where rolename = 'USER2') r,
                      (select id from users where username ='Nick') u

GO

insert into users_roles
select r.id, u.id from
                      (select id from roles where rolename = 'ADMIN') r,
                      (select id from users where username ='Admin') u

GO

insert into users_tasks
select t.id, u.id from
                      (select id from tasks where taskname = 'task1') t,
                      (select id from users where username ='Liz') u

GO

insert into users_tasks
select t.id, u.id from
                      (select id from tasks where taskname = 'task2') t,
                      (select id from users where username ='Nick') u

GO

insert into users_tasks
select t.id, u.id from
                      (select id from tasks where taskname = 'task3') t,
                      (select id from users where username ='Liz') u

GO

